package rough;

import java.util.Random;

import org.testng.annotations.Test;

public class invokeCountDemoCreateUser {

	private static int recNo = 1;
	@Test(invocationCount=5)
	public void createUser()
	{
		Random random = new Random();
		long rndVal = random.nextInt(100000);
		System.out.println("Hello " + recNo++ + "User" +rndVal);
	}
}


















