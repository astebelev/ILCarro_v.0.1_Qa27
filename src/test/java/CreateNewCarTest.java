import manager.DataProviders;
import models.Car;
import models.User;
import org.testng.Assert;
        import org.testng.annotations.AfterMethod;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.Test;

public class CreateNewCarTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        if(!app.user().islogged()){
            app.user().loggin(new User().withEmail(app.setEmail()).withPassword(app.setPassword()));
        }

    }

    @Test
    public void createNewCar() {

        Car car=new Car().withLocation("Tel-Aviv")
                .withMake("Subaru")
                .withModel("Forester")
                .withYear("2017")
                .withEngine("2000")
                .withFuel("Petrol")
                .withGear("AT")
                .withWd("RWD")
                .withDoors("5")
                .withSeats("5")
                .withCarClass("Luxury")
                .withFuelConsumption("10")
                .withCarRegNum("79021435")
                .withPrice("350")
                .withDistanceIncluded("500")
                ;

        app.car().opencarCreationForm();

        app.car().fillCarForm(car);

        app.car().attachFoto("C:/Users/Stebelev/Pictures/Subaru.jpg");
        app.car().pause(2000);
        app.car().saveNewCar();
        //app.car().pause(2000);
        Assert.assertTrue(app.car().isCarAdded());
    }
    //__________________________________________________
    @Test(dataProvider = "dataCarFile",dataProviderClass = DataProviders.class)
    public void createNewCarDataProvider(Car car) {



        app.car().opencarCreationForm();

        app.car().fillCarForm(car);

        app.car().attachFoto("C:/Users/Stebelev/Pictures/Subaru.jpg");
        app.car().pause(2000);
        app.car().saveNewCar();
        //app.car().pause(2000);
        Assert.assertTrue(app.car().isCarAdded());
        app.car().refresh();
    }

    @AfterMethod
    public void postConditions() {


    }
}