package manager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    EventFiringWebDriver wd;
    UserHelper user;
    CarHelper car;
    SearchHelper search;
    String browser;
    Properties properties;
    JScriptHelper jsHelper;

    public ApplicationManager(String browser)
    {
        this.browser = browser;
        properties=new Properties();
    }


    public void init() throws IOException {
        String target = System.getProperty("target", "v1");
        properties
                .load(new FileReader(new File(String.format("src/test/resources/%s.properties",target))));



        if (browser.equals(BrowserType.CHROME)) {
            wd = new EventFiringWebDriver(new ChromeDriver());
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new EventFiringWebDriver(new FirefoxDriver());
        }

        wd.register(new MyListener());

        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //wd.navigate().to("https://ilcarro.xyz/search");

        wd.navigate().to(properties.getProperty("web.baseURL"));

        user = new UserHelper(wd);
        car = new CarHelper(wd);
        search= new SearchHelper(wd);
        jsHelper = new JScriptHelper(wd);

    }
    public String setEmail(){
      return properties.getProperty("web.email");
    }
    public String setPassword() {
        return properties.getProperty("web.password");
    }
    public void stop() {

        wd.quit();
    }

    public CarHelper car() {
        return car;
    }

    public UserHelper user() {
        return user;
    }

    public SearchHelper search() {
        return search;
    }

    public JScriptHelper executor() {
        return jsHelper;
    }
}