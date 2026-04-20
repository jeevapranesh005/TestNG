import org.testng.annotations.Test;

public class AssertDemo {
  @Test
  public void f() {
	  
	  String str1 = new String("Hello");
	  String str2 = new String("Hello");
	  String str3 = null;
	  String str4="TestNG";
	  String str5="TestNG";
	  String str6 = new String("NOT_TestNG");
	  
	  int val1=5;
	  int val2=6;
	  
	  //
	  Assert.assertEquals(str1,str2);
	  System.out.println("Equals assesment is successful");
  }
}
