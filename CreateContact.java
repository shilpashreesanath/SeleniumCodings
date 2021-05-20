package week2.day2.assignments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;



public class CreateContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Contacts").click();
		driver.findElementByLinkText("Create Contact").click();
		
		driver.findElementById("firstNameField").sendKeys("Shilpa");
		driver.findElementById("lastNameField").sendKeys("Shilpa");
		driver.findElementById("createContactForm_firstNameLocal").sendKeys("shillu");
		driver.findElementById("createContactForm_lastNameLocal").sendKeys("shree");
		driver.findElementByXPath("//input[@id='createContactForm_departmentName']").sendKeys("Selenium");
		driver.findElementByXPath("//textarea[@class='inputBox'][@name='description']").sendKeys("Learning Selenium");
		driver.findElementById("createContactForm_primaryEmail").sendKeys("shilpashreesanath@gmail.com");
		WebElement state=driver.findElementById("createContactForm_generalStateProvinceGeoId");
		Select dropdown=new Select(state);
		dropdown.selectByVisibleText("New York");
		driver.findElementByXPath("//input[contains(@name,'submit')]").click();
		
		driver.findElementByXPath("//a[contains(text(),'Edit')]").click();
		driver.findElementByXPath("//textarea[@class='inputBox'][@name='description']").clear();
		driver.findElementByXPath("//textarea[@class='inputBox'][@name='importantNote']").sendKeys("Learning Selenium");
		driver.findElementByXPath("//input[contains(@name,'submit')]").click();
		System.out.println(driver.getTitle());
		
		
		
		

	}

}
