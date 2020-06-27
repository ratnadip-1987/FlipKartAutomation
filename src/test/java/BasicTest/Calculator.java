package BasicTest;
import org.testng.annotations.Test;
import junit.framework.Assert;

public class Calculator {
	
	@Test(priority=1)
	public void SUM()
	{
		System.out.println("SUM");
		int a=10;
		int b=20;
		Assert.assertEquals(30, a+b);
	}
	
	@Test(priority=2)
	public void Div()
	{
		System.out.println("Div");
		int a=20;
		int b=2;
		Assert.assertEquals(10, a/b);
	}
	
	@Test(priority=3)
	public void Sub()
	{
		System.out.println("Sub");
		int a=20;
		int b=2;
		Assert.assertEquals(18, a-b);
	}

}
