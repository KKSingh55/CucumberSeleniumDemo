package stepDefination;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import PageObject.addCustomerPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;


public class Step extends BaseClass {
	
	public SearchCustomerPage searchCust1;
	public Properties configProp;
	
@Before	
public void setup() throws IOException {
	
	logger = Logger.getLogger("CucumberSeleniumDemo");
	PropertyConfigurator.configure("log4j.properties");
	logger.setLevel(Level.INFO);
	
	configProp = new Properties();
	FileInputStream fis = new FileInputStream("config.properties");
	configProp.load(fis);
	
	String br =configProp.getProperty("browsers");
	
	

	if(br.equals("chrome")) {
	
	System.setProperty("webdriver.chrome.driver",configProp.getProperty("chromepath"));
			
	
	driver = new ChromeDriver();
	}
	
	else if(br.equals("firefox")) {
		
		System.setProperty("webdriver.gecko.driver",configProp.getProperty("firefoxpath"));
		
		driver = new FirefoxDriver();
	}
	
	else if(br.equals("IE")) {
		
		System.setProperty("webdriver.ie.driver",configProp.getProperty("iepath"));
				
		
		driver = new InternetExplorerDriver();
	}
	
}
	
@Given("User Launch Chrome browser")
public void user_Launch_Chrome_browser() {
	
	logger.info("*******************Lauching broswer************************");
	lp = new LoginPage(driver);
	 
}

@When("User opens URL {string}")
public void user_opens_URL(String url) {
	
	logger.info("************************Opening URL*****************************");
	
	driver.get(url);
	driver.manage().window().maximize();
}

@When("Users enters Email as {string} and password as {string}")
public void users_enters_Email_as_and_password_as(String Email, String Password) {
	
	logger.info("************************Providing username and password*****************************");
	lp.setUserName(Email);
	lp.setPassword(Password);
    
}

@Then("Click on Login")
public void click_on_Login() {
	logger.info("************************Clicking login button*****************************");
	
	lp.clickLogin();
   
}

// validating page title

@Then("page Title should be {string}")
public void page_Title_should_be(String title) throws InterruptedException {
	
	
	if(driver.getPageSource().contains("Dashboard / nopCommerce administration")) {
		
		
		logger.info("************************login passed*****************************");
		
		Assert.assertTrue(true);
	}
	
	else
	{
		
		Assert.assertTrue(false);
	}
	
	
	
	Thread.sleep(3000);
	
	
}

@When("User click on Log out link")
public void user_click_on_Log_out_link() throws InterruptedException {
	
	logger.info("************************clicked on logout button*****************************");
	
	Thread.sleep(3000);
	
	lp.clickLogout();
    
}

@Then("Page title should be {string}")
public void page_title_should_be(String exptitle) {
	
	if(driver.getPageSource().contains("Your store. Login")) {
		
		Assert.assertTrue(true);
		}
	
	else
	{
		logger.info("************************login passed*****************************");
		Assert.assertEquals(exptitle,driver.getTitle());
	}
    
   
}

@Then("close browser")
public void close_browser() {
	driver.close();
   
}


@Then("User can view Dashboard")
public void user_can_view_Dashboard() {
	
	addcust = new addCustomerPage(driver);
	Assert.assertEquals("Dashboard / nopCommerce administration",addcust.getPageTitle());
	
    
}

@When("user click on customer menu")
public void user_click_on_customer_menu() throws InterruptedException {
	Thread.sleep(3000);
	addcust.clickOnCustomerMenu();
    
}

@When("click on customer menu item")
public void click_on_customer_menu_item() throws InterruptedException {
	Thread.sleep(3000);
	addcust.clickOnCustomerMenuItem();
   
}

@When("click on Add new button")
public void click_on_Add_new_button() throws InterruptedException {
	Thread.sleep(3000);
	addcust.clickOnAddnew();
   
}

@Then("User can view Add new customer page")
public void user_can_view_Add_new_customer_page() throws InterruptedException {
	Thread.sleep(3000);
	Assert.assertEquals("Add a new customer / nopCommerce administration",addcust.getPageTitle());
	
   
}

@Then("User enter customer info")
public void user_enter_customer_info() throws InterruptedException {
	
	String email = randomstring()+ "@gmail.com";
	addcust.setEmail(email);
	addcust.setPassword("pd123");
	addcust.setName("kanhiya");
	addcust.setLastName("kumar singh");
	addcust.setGender("Male");
	addcust.setDob("3/10/2022");//m/dd/yy
	addcust.companyName("clavrit.org");
	addcust.isTxexempt();
	addcust.setCustomersRole("Guests");
	Thread.sleep(3000);
	addcust.setMangerofVendor("Vendor2");
	addcust.setAdminComment("this is testing");
}

@Then("click on save button")
public void click_on_save_button() throws InterruptedException {
	
	//Thread.sleep(3000);
	addcust.clickOnSave();
    
}

@Then("User can view confirmation message {string}")
public void user_can_view_confirmation_message(String string) {
	
	Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
	

}


// searching customer with email

@When("Enter customer Email")
public void enter_customer_Email() {
	
	searchCust1 = new SearchCustomerPage(driver);
	searchCust1.setEmail("steve1_gates@nopCommerce.com");
    
}

@When("click on search button")
public void click_on_search_button() throws InterruptedException {
	searchCust1.clickSearch();
	Thread.sleep(3000);
	
	
}

@Then("User should found in the search table")
public void user_should_found_in_the_search_table() {
	boolean status = searchCust1.searchCustomerByEmail("steve_gates@nopCommerce.com");
	Assert.assertEquals(true,status );
   
}

@Then("close browsers")
public void close_browsers() {
	
	driver.close();
	
	
  
}












}
