package sharedData;

import loggerUtility.LoggerUtility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Hooks extends SharedData {

    public LoggerUtility loggerUtility = new LoggerUtility();

    @BeforeMethod
    public void prepareEnvironment() {
        super.prepareEnvironment();
        loggerUtility.startTest("AlertTest");
    }

    @AfterMethod
    public void clearEnvironment() {
        super.clearEnvironment();
        loggerUtility.finishTest("AlertTest");
    }
}