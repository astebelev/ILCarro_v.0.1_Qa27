package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarHelper extends HelperBase{
    public CarHelper(WebDriver wd) {
        super(wd);
    }

    public void opencarCreationForm() {
        click(By.xpath("//a[@href='/let-car-work']"));
    }
    public void fillCarForm(Car car) {
        wd.findElement(By.xpath("//a[@id='1']")).click();
        type(By.id("pickUpPlace"), car.getLocation());
        click(By.cssSelector("div.pac-item"));
        pause(2000);
        type(By.id("make"), car.getMake());
        type(By.id("model"), car.getModel());
        type(By.id("year"), car.getYear());
        type(By.id("engine"), car.getEngine());
        select(By.id("fuel"),car.getFuel());
        select(By.id("gear"),car.getGear());
        select(By.id("wheelsDrive"),car.getWd());
        type(By.id("doors"), car.getDoors());
        type(By.id("seats"), car.getSeats());
        type(By.id("class"), car.getCarClass());
        type(By.id("fuelConsumption"), car.getFuelConsumption());
        type(By.id("serialNumber"), car.getCarRegNum());
        type(By.id("price"), car.getPrice());
        type(By.id("distance"), car.getDistanceIncluded());
        //type(By.cssSelector(".feature-input"), car.getFeature);

    }
    public void saveNewCar() {
        click(By.xpath("//button[text()='Submit']"));
        //wd.findElement(By.xpath("//button[text()='Submit']")).submit();
    }

    public boolean isCarAdded() {
        new WebDriverWait(wd,10)
                .until(ExpectedConditions.visibilityOf(wd.findElement
                        (By.cssSelector("div.dialog-container"))));

        String text=wd.findElement(By.cssSelector("div.dialog-container h1")).getText();
        return text.contains("added");
    }

    public void refresh() {
        wd.navigate().refresh();
    }


}