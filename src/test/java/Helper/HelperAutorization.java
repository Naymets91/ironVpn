package Helper;

import Config.Values;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HelperAutorization {

    @Step("Подтверждения политики")
    public void clickButtonGetNov() {
        $(By.id("validate")).click();
    }

    public void clickPolicy() {
        $(By.xpath("//i[@class='checkplace']")).click();
    }
    @Step ("Заполнения поля емейл")
    public void fillEmail(){
        $(By.name("button")).click();
        $(By.id("email")).click();
        $(By.id("email")).sendKeys(Values.email);
    }
}
