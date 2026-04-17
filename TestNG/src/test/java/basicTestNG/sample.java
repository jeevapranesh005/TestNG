package basicTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class sample {
  @Test
  public void a() {
	  System.out.println("heii");
  }
  
  @Test
  public void b() {
	  System.out.println("hello");
  }
  
  @Test
  public void c() {
	  System.out.println("Welcome");
  }
  
  
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
