package week2.day2.assignments;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

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
		
		driver.findElementByXPath("//span[text()='Email']").click();
		driver.findElementByXPath("//input[@type='text'][@name='emailAddress']").sendKeys("shilpa@gmail.com");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(3000);
		
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").getText();
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		
		driver.findElementByLinkText("Duplicate Lead").click();
		String title=driver.getTitle();
		if(title.equals("Duplicate Lead | opentaps CRM")) {
			System.out.println("Title is matching");
		}
		else {
			System.out.println("Title is not matching");
		}
		
		Thread.sleep(3000);
		driver.findElementByXPath("//input[@type='submit'][@class='smallSubmit']").click();
		String text=driver.findElementByXPath("//span[@id='viewLead_firstName_sp']").getText();
		System.out.println(driver.findElementByXPath("//span[@id='viewLead_firstName_sp']").getText());
		
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("//span[text()='Email']").click();
		driver.findElementByXPath("//input[@type='text'][@name='emailAddress']").sendKeys("shilpa@gmail.com");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]").click();
		String text1=driver.findElementByXPath("//span[@id='viewLead_firstName_sp']").getText();
		//System.out.println(driver.findElementByXPath("//span[@id='viewLead_firstName_sp']").getText());
		System.out.println("text is" + text1);
		if(text.equals(text1)) {
			System.out.println("Both names are same");
		}
		else {
			System.out.println("Names are different");
		}
		driver.close();
		

	}

}
