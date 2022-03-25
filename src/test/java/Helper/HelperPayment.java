package Helper;

import Config.Values;
import Pages.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.io.FileNotFoundException;
import java.io.IOException;

import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class HelperPayment extends Page {
    @Step("Проверка пароля")
    public void checkPassword() {
        String saitPassword = $(By.xpath("//div[@class='access-block']/p[2]")).getText();
        saitPassword = saitPassword.replace("Password: ", "");
        Integer length = saitPassword.length();
        if (length > 0) {
            print("Пароль содержит  символы " + saitPassword );
            makeScreenshot("screen");
        } else  {
            print("Пароль содержит = 0 символов  " + saitPassword );
            makeScreenshot("screen");
            throw new Error();
        }
    }
    @Step ("Проверка логина")
    public void checkLogin() {
        String saitLogin = $(By.xpath("//div[@class='access-block']/p[1]")).getText();
        saitLogin = saitLogin.replace("Login: ", "");
        if (saitLogin.equals(Values.email)) {
            print("Логин верно указан " + saitLogin );
            makeScreenshot("screen");
        } else  {
            print("!!!Логин НЕ верно указан " + saitLogin );
            makeScreenshot("screen");
            throw new Error();
        }
    }
    @Step ("Проверка Емейла")
    public void checkEmails() {
        String saitEmail = $(By.xpath("//div[@class='col-12']//p[@class='mail']")).getText();
        if (saitEmail.equals(Values.email)) {
            print("Емайл верно указан " + saitEmail );
            makeScreenshot("screen");
        } else  {
            print("!!!Емайл НЕ верно указан " + saitEmail );
            makeScreenshot("screen");
            throw new Error();
        }
    }
    @Step ("Проверка Проверка сообщения")
    public void checkMessages() {
        String saitMessages = $(By.xpath("//div[@class='col-12']/h3")).getText();
        if (saitMessages.equals(Values.paymentMessages)) {
            print("Присутствует сообщения об оплате");
            makeScreenshot("screen");
        } else  {
            print("!!!!ОТСУТСТВУЕТ сообщения об оплате");
            makeScreenshot("screen");
            throw new Error();
        }
    }

    public void fillCreditCard(String creditCard) {
        $(By.name("cardNumber")).shouldBe(visible).click();
        $(By.name("cardNumber")).sendKeys(creditCard);
    }

    public void fillcardExpiryDate(String date) {
        $(By.name("cardExpiryDate")).shouldBe(visible).click();
        $(By.name("cardExpiryDate")).sendKeys(date);
    }

    public void fillcardCvv(String cardCvv) {
        $(By.name("cardCvv")).shouldBe(visible).click();
        $(By.name("cardCvv")).sendKeys(cardCvv);
    }
@Step("Проверка наличия ошибки под формой")
    public void checkErrors(String eroorId) {
        Boolean errorsSite = $(By.id(""+ eroorId+"")).exists();
        if (errorsSite == true) {
            print("Присутствует ошибка ");
        } else {
            print("Отсутствует ошибка " );
            makeScreenshot("screen");
            throw new Error();
        }
        makeScreenshot("screen");
    }
    @Step("Проверка кнопка оплати")
    public void checkActiveButtonPay() {
        boolean submitButton = $(By.name("submitButton")).isEnabled();
        if (submitButton == false ){
         print("Кнопка оплаты неактивна");
        } else {
            print("Кнопка оплаты активна!!!!!" );
            makeScreenshot("screen");
            throw new Error();
        }
        makeScreenshot("screen");
    }
}
