package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    static WebDriver wd;
    UserHelper user;

    public UserHelper user() {
        return user;
    }


    public void init() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://ilcarro.xyz/search");
        user = new UserHelper(wd);
    }

    public void stop() {
        wd.quit();
    }
}
