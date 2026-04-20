package sharedData;

import loggerUtility.LoggerUtility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class Hooks extends SharedData {

    public LoggerUtility loggerUtility = new LoggerUtility();

    @BeforeMethod
    public void prepareEnvironment(Method method) {
        super.prepareEnvironment();
        loggerUtility.startTest(getTestName(method));
    }

    @AfterMethod
    public void clearEnvironment(Method method) {
        loggerUtility.finishTest(getTestName(method));
        super.clearEnvironment();
    }

    public String getTestName(Method method) {
        String className = method.getDeclaringClass().getSimpleName();

        if (className.equals("AlertTest")) {
            return "AlertTest";
        }
        if (className.equals("FramesTest")) {
            return "FramesTest";
        }
        if (className.equals("PracticeForms")) {
            return "PracticeForms";
        }
        if (className.equals("TabWindowTest")) {
            return "TabWindowTest";
        }
        if (className.equals("WebTableTest")) {
            return "WebTableTest";
        }

        return method.getName();
    }
}