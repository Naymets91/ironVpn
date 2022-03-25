package Pages;

import Config.Values;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Page {



    Integer size;
    public String tempStrPage;


    @Step("Переход на сайт ")
    public void openHomePage() {
        open(Values.homePage);
    }

    @Attachment(value = "{0}", type = "image/png")
    public static byte[] makeScreenshot(String name) {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    public void print(String text){
        Allure.attachment("Результат", text);
        System.out.println(text);
    }

    public void finndSizeTrue(By locator, String textTrue, String textFalse ) {
        if($$(locator).size() != 0) {
            Allure.attachment("Результат", textTrue);
            System.out.println(textTrue);
        } else {
            Allure.attachment("Результат", textFalse);
            System.out.println(textFalse);
            throw new Error();
        }
    }
    public void finndSizeFalse(By locator, String textFalse, String textTrue ) {

        if($$(locator).size() == 0) {
            Allure.attachment("Результат", textFalse);
            System.out.println(textFalse);
        } else {
            Allure.attachment("Результат", textTrue);
            System.out.println(textTrue);
            throw new Error();
        }
    }


    public boolean find(By locator) {
        if($$(locator).size() != 0){
            System.out.println("true");
            return true;
        } else{
            System.out.println("false");
            return false;
        }
    }


    public void switcToWindowsTab(int index) {
        switchTo().window(index);       // переключения на 2 вкладку
    }



    public int getRandomNumber(int a1, int b1) {
        int a = a1;
        int b = b1;
        int x = a + (int) (Math.random() * ((b - a) + 1));
        //System.out.println("Случайное число x: " + x);
        return x;
    }

    // Рандомное заполнения имен
    public StringBuilder randomStringEN(int s) {
        String symbols = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder randString = new StringBuilder();
        int count = s;
        for (int i = 0; i < count; i++)
            randString.append(symbols.charAt((int) (Math.random() * symbols.length())));
        return randString;
    }


    public StringBuilder randomStringRU(int s) {
        String symbols = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        StringBuilder randString = new StringBuilder();
        int count = s;
        for (int i = 0; i < count; i++)
            randString.append(symbols.charAt((int) (Math.random() * symbols.length())));
        return randString;
    }

    public boolean finde (By locator) {
        try {
            $(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    }
