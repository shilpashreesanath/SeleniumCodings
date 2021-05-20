package week2.day2.assignments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByXPath("//a[contains(text(),'Find Leads')]").click();
		
		driver.findElementByXPath("//span[text()='Phone']").click();
		driver.findElementByXPath("//input[@type='text'][@name='phoneNumber']").sendKeys("7795662247");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		
		String user = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").getText();
		System.out.println(driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").getText());
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		
		driver.findElementByLinkText("Delete").click();
		
		driver.findElementByXPath("//a[contains(text(),'Find Leads')]").click();
		driver.findElementByName("id").sendKeys("user");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		
		Thread.sleep(2000);
		String verify=driver.findElementByClassName("x-paging-info").getText();
		if(verify.equals("No records to display")) {
			System.out.println("Text matched");
		}
		else {
			System.out.println("Text not matched");
		}
		driver.close();
		
	
	}

}
