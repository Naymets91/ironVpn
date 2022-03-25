package Pages;

import Config.Values;
import Helper.HelperAutorization;
import Helper.HelperPayment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class VpnPage extends  Page{

HelperPayment helpPay = new HelperPayment();
HelperAutorization helpAutorization = new HelperAutorization();

@Step ("Авторизация ")
    public void authorization() {
    helpAutorization.fillEmail();
    helpAutorization.clickPolicy();
    helpAutorization.clickButtonGetNov();
    System.out.println("Авторизация ");
    makeScreenshot("screen");
    }
    @Step ("Покупка сервиса")
    public void payment() {
        $(By.name("button")).click();
        switchTo().frame($("[id='solid-payment-form-iframe']"));
        helpPay.fillCreditCard(Values.creditCard);
        helpPay.fillcardExpiryDate(Values.date);
        helpPay.fillcardCvv(String.valueOf(Values.codeCVV));
        sleep(2000);
        $(By.name("submitButton")).click();
        makeScreenshot("screen");
        System.out.println("Покупка сервиса");
    }

    @Step ("Проверка после оплаты")
    public void equalsPay() {
        System.out.println("");
        helpPay.checkMessages();
        helpPay.checkEmails();
        helpPay.checkLogin();
        helpPay.checkPassword();
    }





    @Step ("Оплата с простроченою датой карточки")
    public void paymentExpiredCardDate() {
        System.out.println("Оплата с простроченою датой карточки");
        $(By.name("button")).click();
        sleep(4000);
        switchTo().frame($("[id='solid-payment-form-iframe']"));
        helpPay.fillCreditCard(Values.creditCard);
        helpPay.fillcardExpiryDate("32020");
        sleep(2000);
        helpPay.checkErrors("cardExpiryDate_error-text");


        helpPay.checkActiveButtonPay();
    }
    @Step ("Оплата без ввода реквизитов")
    public void paymentNotDetails() {
        System.out.println("Оплата без ввода реквизитов");
        $(By.name("button")).click();
        sleep(4000);
        switchTo().frame($("[id='solid-payment-form-iframe']"));
        helpPay.checkActiveButtonPay();
    }
    @Step ("Оплата без ввода номера карточки")
    public void paymentNotCartNumber() {
        System.out.println("Оплата без ввода номера карточки");
        $(By.name("button")).click();
        sleep(4000);
        switchTo().frame($("[id='solid-payment-form-iframe']"));
        $(By.name("cardNumber")).shouldBe(visible).click();
        helpPay.fillcardExpiryDate(Values.date);
        helpPay.fillcardCvv(String.valueOf(Values.codeCVV));
        sleep(2000);

        helpPay.checkActiveButtonPay();
    }

    public void paymentInvalidCartNumber() {
        $(By.name("button")).click();
        switchTo().frame($("[id='solid-payment-form-iframe']"));
        helpPay.fillCreditCard("44444444");
        helpPay.fillcardExpiryDate(Values.date);
        helpPay.fillcardCvv(String.valueOf(Values.codeCVV));
        sleep(2000);

        helpPay.checkErrors("cardNumber_error-text");
        helpPay.checkActiveButtonPay();
    }
}
