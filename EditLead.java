package week2.day2.assignments;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

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
		driver.findElementByLinkText("Find Leads").click();
		
		driver.findElementByXPath("(//input[@type='text'][@name='firstName'])[3]").sendKeys("Shilpa");
		//driver.findElementByXPath("(//button[@class='x-btn-text'][@type='button'])[7]").click();
		driver.findElementByXPath("//button[contains(text(),'Find Leads')]").click();
		//driver.findElementByClassName("Find Leads").click(); not working as the button class name is not find leads
		Thread.sleep(10000);
		
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		String title=driver.getTitle();
		if(title.equals("View Lead | opentaps CRM")) {
			System.out.println("you are in right page");
		}
		else {
			System.out.println("Wrong page");
		}
		
		String text=driver.findElementByXPath("//span[@id='viewLead_companyName_sp']").getText();
		System.out.println("Comapany name is:" + text);
		driver.findElementByLinkText("Edit").click();
		Thread.sleep(1000);
		
		driver.findElementById("updateLeadForm_companyName").clear();
		driver.findElementById("updateLeadForm_companyName").sendKeys("Western Digital");
		driver.findElementByXPath("//input[@class='smallSubmit'][@type='submit']").click();
		Thread.sleep(1000);
		
		String text1=driver.findElementById("viewLead_companyName_sp").getText();
		System.out.println("Company name after update:" + text1);
		if(text.equals(text1)) {
			System.out.println("Company name has not updated!!!!");
		}
		else {
			System.out.println("Company name has been updated properly...");
		}
		

	}

}
