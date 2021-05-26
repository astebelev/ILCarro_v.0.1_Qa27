import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SearchTest extends TestBase{


    @Test
    public void typeSearchPeriod(){
        //      "5/15/2021 - 5/20/2021"
        app.search().fillSearchFormByType ("Haifa","5/25/2021","5/30/2021");
        app.search().pause(2000);
        app.search().clickYallaBtn();
        Assert.assertTrue(app.search().isListOfCarsAppeared());


    }

    @Test
    public void selectSerachPeriod(){
        // 5/15/2021 - 5/25/2021
        app.search().fillSearchFormBySelectDate("Haifa","5/25/2021"," 5/30/2021");
        app.search().pause(2000);
        app.search().clickYallaBtn();
        app.search().pause(2000);
        Assert.assertTrue(app.search().isListOfCarsAppeared());

    }

    @Test
    public void negativeTestTypePeriodInPath(){
        //  4/10/2021 - 4/12/2021
        app.search().fillSearchFormByTypeNeg("Haifa","4/10/2021","4/12/2021");
        Assert.assertTrue(app.search().buttonYallaInactive());
        Assert.assertTrue(app.search().isDataInPath());
        app.search().pause(1000);
    }

    @Test
    public void selectPeriodNotCurrentMount(){

        // 6/1/2021   7/2/2021
        app.search().fillsearchfom("Haifa","6/1/2021","7/12/2021");
        app.search().clickYallaBtn();
        app.search().pause(2000);
        Assert.assertTrue(app.search().isListOfCarsAppeared());
    }

    @AfterMethod()
    public void postConditions(){
        app.search().backToHomePage();
    }
}