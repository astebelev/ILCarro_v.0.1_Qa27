package manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListenerTestNG implements ITestListener {
    Logger logger = LoggerFactory.getLogger(MyListenerTestNG.class);
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        System.out.println("Listener TestsNG start" + result.getTestName()+result.getName());
        logger.info("Listener TestsNG start" + result.getTestName()+result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        System.out.println("Listener TestsNG finish " +context.getName());
        logger.info("Listener TestsNG finish " +context.getName());

    }


}
