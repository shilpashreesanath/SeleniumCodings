package week2.day1.assignments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Duplicate {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		
		String title=driver.getTitle();
		System.out.println("the title is " +title);
		if (title.contains("TestLeaf")) {
			System.out.println("Title contains testleaf");
		}
		
						
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Create Lead").click();
		
		driver.findElementById("createLeadForm_companyName").sendKeys("TestLeaf");
		driver.findElementById("createLeadForm_firstName").sendKeys("Shilpa");
		driver.findElementById("createLeadForm_lastName").sendKeys("Shree");
		driver.findElementById("createLeadForm_birthDate").sendKeys("10/6/95");
		Thread.sleep(1000);
		driver.findElementByName("submitButton").click();
		
		driver.findElementByLinkText("Duplicate Lead").click();
		driver.findElementById("createLeadForm_companyName").clear();
		driver.findElementById("createLeadForm_companyName").sendKeys("My Own");
		driver.findElementByName("submitButton").click();
		
		WebElement Dul=driver.findElementById("viewLead_companyName_sp");
		String verifyName=Dul.getText();
		String duplicateName="My Own";
		if(verifyName.contains(duplicateName)) {
			System.out.println("Verification Successful");
		}
		else {
			System.out.println("Verification Unsuccessful");
		}
		
		driver.close();
		
		
		

	}

}
