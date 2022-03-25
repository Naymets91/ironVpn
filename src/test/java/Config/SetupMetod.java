package Config;


import Pages.Page;
import io.qameta.allure.Step;
import org.testng.ITestResult;

import java.lang.reflect.Method;


public class SetupMetod  extends Page {

@Step ("Переход на страницу rozetka.com.ua")
    public void startMethod() {
        openHomePage();
    }


public void finishMethod(ITestResult testResult, Method method) {

    String result = ">>> ============= Result of test " + method.getName();
    if (testResult.isSuccess()) System.out.print(result + " is OK");
    else {
        makeScreenshot("Screenshot END of " + method.getName());
        System.out.print(result + " is FAIL");
    }
    System.out.println(" ================ <<<\n");
    System.out.println(" ");
    System.out.println(" ");

}
}

