import Config.SetupClass;
import Config.SetupMetod;
import Pages.VpnPage;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class Ironvpn {

    SetupClass setupClass = new SetupClass();
    SetupMetod setupMetod = new SetupMetod();
    VpnPage vpnPg = new VpnPage();


    @BeforeClass
    public void setUpBeforeClass() {
        setupClass.startClass(true);
    }

    @BeforeMethod
    public void setUpBeforeMethod() {
        setupMetod.startMethod();
    }

    @Test (priority = 1)
    public void positivePayment() {
        vpnPg.authorization();
        vpnPg.payment();
        vpnPg.equalsPay();
    }

    @Test (priority = 2)
    public void paymentWithoutEnteringDetails() {
        vpnPg.authorization();
        vpnPg.paymentNotDetails();
    }

    @Test (priority = 3)
    public void paymentWithAnExpiredCardDate() {
        vpnPg.authorization();
        vpnPg.paymentExpiredCardDate();
    }
    @Test (priority = 4)
    public void paymentWithoutEnteringCardNumber() {
        vpnPg.authorization();
        vpnPg.paymentNotCartNumber();
    }
    @Test (priority = 5)
    public void paymentInvalidCardNumber() {
        vpnPg.authorization();
        vpnPg.paymentInvalidCartNumber();
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult, final Method method) {
        setupMetod.finishMethod(testResult, method);
    }

    @AfterClass
    public void afterClass() {
        setupClass.finishClass();
    }

}


