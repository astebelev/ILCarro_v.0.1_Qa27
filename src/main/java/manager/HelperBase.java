package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

    public void type(By locator, String text){
        if(text!=null){
            WebElement el=wd.findElement(locator);
            el.click();
            el.clear();
            el.sendKeys(text);
        }
    }

    public void typeWithCntrV(String from, String to){
        WebElement element = wd.findElement(By.id("dates"));
        element.click();
        String os = System.getProperty("os.name");
        System.out.println(os);
        if (os.startsWith("Mac")){
            element.sendKeys(Keys.chord (Keys.COMMAND, "a"));
        }else{
            element.sendKeys(Keys.chord (Keys.CONTROL, "a"));
        }
        element.sendKeys(from + " - "+to);
        element.sendKeys(Keys.ENTER);
    }

    public void pause(int milles) {

        try {
            Thread.sleep(milles);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }

    public void select(By locator,String option){

        new Select(wd.findElement(locator)).selectByVisibleText(option);
    }

    public  void attachFoto(String link){
        wd.findElement(By.id("photos")).sendKeys(link);

    }


}