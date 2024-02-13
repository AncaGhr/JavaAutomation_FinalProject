package ShareData;

import Logger.LoggerUtility;
import PropertyUtility.PropertyUtility;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;

public class Hooks {

    public HashMap<String, String> testData;
    public String testName;

    @BeforeMethod

    public void prepareEnvironment() {

        testName = this.getClass().getSimpleName();
        PropertyUtility propertyUtility = new PropertyUtility(testName);
        testData = propertyUtility.getAllData();
        LoggerUtility.startTestCase(testName);

    }

    @AfterMethod

    public void clearEnvironment(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            LoggerUtility.error(result.getThrowable().getMessage());
        }
        LoggerUtility.endTestCase(testName);
    }

}

