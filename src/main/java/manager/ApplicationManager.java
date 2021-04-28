package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    UserHelper user;
    CarHelper car;

    public UserHelper user() {
        return user;
    }

    public void init() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://ilcarro.xyz/search");
        user = new UserHelper(wd);
        car = new CarHelper(wd);

    }

    public void stop() {

        wd.quit();
    }

    public CarHelper car() {
        return car;
    }
}
