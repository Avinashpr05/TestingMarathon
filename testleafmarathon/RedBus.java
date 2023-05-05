package testleafmarathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RedBus {
	// driver.findElement(By("")).click();
	// driver.findElement(By("")).sendKeys("");
	

	public static void main(String[] args) throws InterruptedException {
		
		// Code to disable browser notification
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		
		//	1.	Launch Firefox / Chrome / Edge / Safari 
		ChromeDriver driver = new ChromeDriver(option);
		
		//	2.	Load https://www.redbus.in/ and add  implicitlyWait		
		driver.get("https://www.redbus.in/bus-tickets");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//	3.	Type "Chennai" in the FROM text box
		//driver.findElement(By.xpath("//text[@class='placeHolderMainText']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//input[@id='txtSource']")).sendKeys("Chennai");
		
		//	4.	Click the first option from the pop up box
		driver.findElement(By.xpath("//ul[@id='C120_suggestion-wrap']/div")).click();
		
		//	5.	Type "Bangalore" in the TO text box
		driver.findElement(By.id("txtDestination")).sendKeys("Bangalore");		
		
		//	6.	Click the first option from the pop up box
		driver.findElement(By.xpath("//ul[@id='C120_suggestion-wrap']/div")).click();
		
		//	7.	Select tomorrow's date in the Date field 6
		driver.findElement(By.id("txtOnwardCalendar")).click();
//		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[contains(@class,'today')]/following-sibling::li")).click();
		
		Thread.sleep(1000);
		//	8.	Click Search Buses
		driver.findElement(By.xpath("//button[@class='D120_search_btn searchBuses']")).click();
		// driver.findElement(By.className("D120_search_btn searchBuses")).click();
		// driver.findElement(By.tagName("button")).click();

		// Thread.sleep(1000);
		//	9.	Print the number of buses shown as results (104 Buses found) (use .getText())
		String noOfBus = driver.findElement(By.xpath("//span[contains(@class,'w-60')]")).getText();
		System.out.println(noOfBus);
		
		
		//	10.	Choose SLEEPER in the left menu 
		driver.findElement(By.xpath("//label[@for='bt_SLEEPER']")).click();
		// String noOfBus1 = driver.findElement(By.xpath("//span[contains(@class,'w-60')]")).getText();
		// System.out.println(noOfBus1);
		
		//	11.	Print the name of the second resulting bus (use .getText())
		String BName2 = driver.findElement(By.xpath("(//div[contains(@class,'travels')])[2]")).getText();
		System.out.println(BName2);
		
		//	12.	Get the Title of the page(use .getTitle())
		System.out.println(driver.getTitle());

	}

}
