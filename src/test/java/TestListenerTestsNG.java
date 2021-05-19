import manager.MyListenerTestNG;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyListenerTestNG.class)
public class TestListenerTestsNG {

    WebDriver webDriver = new ChromeDriver();
    @Test
    public void testListener(){
        webDriver.navigate().to("https://ru.wikipedia.org/");
        webDriver.quit();
    }
}