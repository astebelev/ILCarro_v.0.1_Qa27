package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

import com.google.common.io.Files;


public class MyListener extends AbstractWebDriverEventListener {

    Logger logger= LoggerFactory.getLogger(MyListener.class);

    public MyListener() {
        super();
    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        super.beforeNavigateTo(url, driver);
        // System.out.println("Start navigate to -->"+url);
        logger.info("Start navigate to-->" +url);
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        super.beforeFindBy(by, element, driver);
        logger.info("Start search element-->" +by);
    }

    @Override
    public void beforeAlertAccept(WebDriver driver) {
        super.beforeAlertAccept(driver);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        super.afterFindBy(by, element, driver);
        logger.info("Found ---> " +by);
    }



    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {

        super.afterClickOn(element, driver);
        //logger.info("Click by " +element.getText());
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        super.onException(throwable, driver);
        logger.info("We have a throwable "+ throwable.getMessage());
        TakesScreenshot screen = ((TakesScreenshot) driver);

        File tmp = screen.getScreenshotAs(OutputType.FILE);

        int i = (int)System.currentTimeMillis()/1000%3600;
        String path = "src/test/screenshots/screenshot-"+ i + ".png";
        logger.info("Screen with throwable --> "+path);
        File screnshot = new File(path);

        try {
            Files.copy(tmp,screnshot);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}

