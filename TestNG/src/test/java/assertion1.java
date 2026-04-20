import org.testng.Assert;
import org.testng.annotations.Test;

public class assertion1 {
	
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
		  
		  Assert.assertFalse(val1>val2);
		  System.out.println("false Assertion is successful");
		  
		  Assert.assertNotNull(str1);
		  System.out.println("not null Assertion successful");
		  
		  Assert.assertNull(str3);
		  
		  
		  Assert.assertSame(str4,str5 );
		  System.out.println("same Assertion is successful");
		  
		  Assert.assertNotSame(str1, str2);
		  System.out.println("Not same Assertion is successful");
	  }
	}

