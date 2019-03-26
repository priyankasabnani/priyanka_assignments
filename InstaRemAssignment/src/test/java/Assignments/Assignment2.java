package Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Assignment2 {

	WebDriver driver;
	
	@Test
	public void Test() throws Exception{
		
		String bankName;
	    String swiftCode;
		int i;
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");  
		ChromeOptions chromeOptions =new ChromeOptions(); // extra for me
		chromeOptions.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"); 
		driver = new ChromeDriver(chromeOptions);  
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.theswiftcodes.com/malaysia/");
		
		int j = 0;
		
		//Looping through the all the rows of the table containing bank data. 
		//The rows with no data are handled in the catch section in the 'isElementPresent()' function
		for(i=2;i<=55;i++){		
			
			if(isElementPresent(By.xpath("/html/body/div[3]/div[1]/div/div[6]/table/tbody/tr["+i+"]/td[2]")))
			{
			j++;
			bankName = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[6]/table/tbody/tr[" + i +"]/td[2]")).getText();
			swiftCode= driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[6]/table/tbody/tr[" + i +"]/td[5]/a")).getText();
			
			System.out.println("Bank Name " + j + ": " + bankName);
			System.out.println("Swift Code " + j + ": " + swiftCode);
			
			}
			
		}
		
		driver.quit();	
	
}

	private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
    }
	
