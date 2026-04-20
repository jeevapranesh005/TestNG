package parameter1;

import org.testng.annotations.DataProvider;

public class dataprovider {

    @DataProvider(name="testData", parallel=true)
    public Object[][] dataProviderfun(){
        return new Object[][] {
            {"jeevs","123"},
            {"wrongUser2","456"}
        };
    }
}