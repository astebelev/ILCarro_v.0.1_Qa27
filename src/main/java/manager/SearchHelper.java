package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;

public class SearchHelper extends HelperBase{
    public SearchHelper(WebDriver wd) {
        super(wd);
    }


    public boolean listOfCarsAppeared(){
        return isElementPresent(By.xpath("//div[@class='search-results']"));
    }

    public void fillSearchFormByType(String city, String dateFrom, String dataTo) {
        fillInputCity(city);
        //************************//typeInputPeriod(dateFrom,dataTo);
        typeWithCntrV(dateFrom,dataTo);
    }

    public void fillSearchFormByTypeVersioWrong(String city,String dateFrom, String dataTo) {
        fillInputCity(city);
        typeWithCntrV(dateFrom,dataTo);
//        type(By.id("dates"),dateFrom+" - "+dataTo);
//        wd.findElement(By.id("dates")).sendKeys(Keys.ENTER);

    }


    private void fillInputCity(String city) {
        type(By.id("city"),city);
        pause(2000);
        click(By.cssSelector("div.pac-item"));
        pause(2000);

    }

    public void clickYallaBtn() {
        click(By.xpath("//button[@type='submit']"));
    }

    public boolean isListOfCarsAppeared() {
        return isElementPresent(By.xpath("//div[@class='search-results']"));
    }

    public void fillSearchFormBySelectDate(String city, String dateFrom, String dateTo) {
        fillInputCity(city);
        selectPeriodCurrentMonth(dateFrom,dateTo);
    }
    //    "5/20/2021"   "5/25/2021"
    private void selectPeriodCurrentMonth(String dateFrom, String dateTo) {

        wd.findElement(By.id("dates")).click();

        String[]from =dateFrom.split("/");
        String[]to = dateTo.split("/");

        String locator =String.format("//div[text()=' %s ']",from[1]);
        click(By.xpath(locator));
        String locator2 =String.format("//div[text()=' %s ']",to[1]);
        click(By.xpath(locator2));

    }

    public void fillSearchFormByTypeNeg(String city, String from, String to) {
        fillInputCity(city);
        typeInputPeriodNeg(from,to);
    }

    private void typeInputPeriodNeg(String from, String to) {
        type(By.id("dates"),from + " - " +to);
//************************
        wd.findElement(By.cssSelector(".cdk-overlay-backdrop")).click();


    }

    public boolean buttonYallaInactive() {
        WebElement button = wd.findElement(By.xpath("//button[@type='submit']"));
        return !button.isEnabled();
    }

    public boolean isDataInPath() {
        String text= wd.findElement(By.xpath("//div[@class='ng-star-inserted']")).getText();
        return text.contains("You can't pick date before today");

    }

    public void fillsearchfom(String city, String from, String to) {
        fillInputCity(city);
        typeInputPeriodCheckData(from,to);
    }
    // "6/1/2021","7/2/2021"
    private void typeInputPeriodCheckData(String from, String to) {

        String[] dataFrom =from.split("/");
        String []dataTo = to.split("/");

        click(By.id("dates"));

        int diffStart=0;

        if(LocalDate.now().getMonthValue()!=Integer.parseInt(dataFrom[0])){
            diffStart=Integer.parseInt(dataFrom[0])-LocalDate.now().getMonthValue();
        }
        System.out.println("Month diffStart: " + diffStart);

        for (int i = 0; i < diffStart; i++) {
            click(By.xpath("//button[@aria-label='Next month']"));
        }
        String locator =String.format("//div[text()=' %s ']",dataFrom[1]);
        click(By.xpath(locator));

        int diff=0;
        if(Integer.parseInt(dataTo[0])!=Integer.parseInt(dataFrom[0])){
            diff = Integer.parseInt(dataTo[0]) - Integer.parseInt(dataFrom[0]);

        }
        for (int i = 0; i < diff; i++) {
            click(By.xpath("//button[@aria-label='Next month']"));
        }


        String locator2 =String.format("//div[text()=' %s ']",dataTo[1]);
        click(By.xpath(locator2));
    }


    //************************
    public void backToHomePage() {
        wd.findElement(By.xpath("//a[@href='/']")).click();
        new WebDriverWait(wd,10)
                .until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//div[@class='search-container']"))));
    }

}