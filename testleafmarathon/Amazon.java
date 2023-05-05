package testleafmarathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Amazon {

	// driver.findElement(By("")).click();
	// driver.findElement(By("")).sendKeys("");

	public static void main(String[] args) {
		// Code to disable browser notification
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");


		//	1.	Launch Firefox / Chrome / Edge / Safari 
		ChromeDriver driver = new ChromeDriver(option);

		//	2.	Load https://www.redbus.in/ and add  implicitlyWait		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//		3.	Type "Bags" in the Search box
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags");
		
		//		4.	Choose the 	 item in the result (bags for boys)
		driver.findElement(By.xpath("//span[contains(text(),'for boys')]")).click();
		
		//		5.	Print the total number of results (like 40000)
		//		1-48 of over 40,000 results for "bags for boys"
		String bRes = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
		System.out.println(bRes);
		
		//		6.	Select the first 2 brands in the left menu
		//		(like American Tourister, Safari)
		driver.findElement(By.xpath("//li[@aria-label='American Tourister']")).click();
		driver.findElement(By.xpath("//li[@aria-label='Safari']/span")).click();

		//		7.	Choose New Arrivals (Sort)
		driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']")).click();
		driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
		
		//		8.	Print the first resulting bag info (name)
		String fBag = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']")).getText();
		System.out.println(fBag);
		
		//		9.	Get the page title and close the browser(driver.close())
		System.out.println(driver.getTitle());
		
		driver.close();


	}

}
