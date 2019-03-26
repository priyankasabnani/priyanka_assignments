package Assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Assignment1 {

WebDriver driver;
	
	@Test
	public void Test() throws Exception{
		
		int i;
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");  //telling that we need to use chrome
		ChromeOptions chromeOptions =new ChromeOptions(); // extra for me
		chromeOptions.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"); //extra for me
		driver = new ChromeDriver(chromeOptions);  //extra for me
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.in/");
		
		//Getting the Products under "Today's Deals" Section and displaying their href in console
		List<WebElement> list1 = driver.findElements(By.xpath("//a[@class='a-link-normal  a-inline-block']"));
		int productCount1 = list1.size();
		//System.out.println("Product count 1 is " + productCount1);		
		for(i=0;i<productCount1;i++)
		{
			System.out.println(list1.get(i).getAttribute("href"));
		}
		
		//Getting the Products under all other sections on Home page and displaying their href in console
		List<WebElement> list2 = driver.findElements(By.xpath("//a[@class='a-link-normal']"));
		int productCount2 = list2.size();
		//System.out.println("Product count 2 is " + productCount2);		
		for(i=0;i<productCount2;i++)
		{
			System.out.println(list2.get(i).getAttribute("href"));
		}
		
			
	}
	
}
