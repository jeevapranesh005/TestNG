package DataProvider;

import org.testng.annotations.DataProvider;
//part1
public class dataProvider {

	
	@DataProvider(name="testData",parallel=true)
	public  Object[][] dataProviderfun(){
		return new Object[][] {{"Selenium"},{"TestNG"},{"automation"}};
	}
}