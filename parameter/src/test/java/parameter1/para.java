package parameter1;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class para {
  
  @Test
  @Parameters({"val1","val2"})
  public void f(@Optional("10") int v1, @Optional("5") int v2)  {
      int sum = v1 + v2;
      System.out.println("sum is: " + sum);
  }
}