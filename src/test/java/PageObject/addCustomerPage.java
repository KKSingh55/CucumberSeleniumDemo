package PageObject;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class addCustomerPage {
	
	

	public WebDriver ldriver;
	public addCustomerPage(WebDriver rdriver)
	{
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	  
	}
	
	By lnkCustomer_menu =By.xpath("//a[@href='#']//i[contains(@class,'nav-icon far fa-user')]");
	By lnkCustomer_menuitem =By.xpath("//body[1]/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/ul[1]/li[1]/a[1]/p[1]");
	By btnAddnew =By.xpath("//a[@class='btn btn-primary']");
	By txtEmail =By.xpath("//input[@id='Email']");
	By txtPassword = By.xpath("//input[@id='Password']");
	By firstName =By.id("FirstName");
	By lastName =By.id("LastName");
	By rdMaleGender =By.id("Gender_Male");
	By rdFeMaleGender =By.id("Gender_Female");
	 
	By txtDob =By.id("DateOfBirth");
	
	By txtCompany = By.id("Company");
	By isTaxexempt =By.id("IsTaxExempt");
	
	By txtCustomerRoles = By.xpath("//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]");
	
	By listitemAdministrato = By.xpath("//li[contains(text(),'Administrators')]");
	By listitemRegistered = By.xpath("//li[contains(text(),'Registered')]");
	By listitemGuest  = By.xpath("//li[contains(text(),'Guests')]");
	By listitemVendors = By.xpath("//li[contains(text(),'Vendors')]");
	By lstitemVendors = By.id("//*[@id='VendorId']");
	By activeCheckbtn =By.id("Active");
	
	By adminComment = By.id("AdminComment");
	
	By saveBtn =By.xpath("//button[@name='save']");
	
	
	
	//Action Method
	
	public String getPageTitle() {
		
		return ldriver.getTitle();
	}
	
	public void clickOnCustomerMenu() {
		
		ldriver.findElement(lnkCustomer_menu).click();
	}
	
	public void clickOnCustomerMenuItem() {
		
		ldriver.findElement(lnkCustomer_menuitem).click();
	}

	public void clickOnAddnew() {
		ldriver.findElement(btnAddnew).click();
	}
	
	public void setEmail(String email) {
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setPassword(String pwd) {
		ldriver.findElement(txtPassword).sendKeys(pwd);
	}
	
	public void setName(String name) {
		ldriver.findElement(firstName).sendKeys(name);
	}
	
	public void setLastName(String lastname) {
		ldriver.findElement(lastName).sendKeys(lastname);
	
	}
	
	
	
	public void setCustomersRole(String role) throws InterruptedException {
	if(!role.equals("Vendors")) //If role is vendors should not delete Register as per req.
	{
	ldriver.findElement(By.xpath("//*[@id='SelectedCustomerRoleIds_taglist']/li/span[2]")).click();
	}
	
	ldriver.findElement(txtCustomerRoles).click();
				
	WebElement listitem;
	
	Thread.sleep(3000);
				
	if(role.equals("Administrators"))
	{
		listitem=ldriver.findElement(listitemAdministrato); 
	}
	else if(role.equals("Guests"))
	{
		listitem=ldriver.findElement(listitemGuest);
	}
	else if(role.equals("Registered"))
	{
		listitem=ldriver.findElement(listitemRegistered);
	}
	else if(role.equals("Vendors"))
	{
		listitem=ldriver.findElement(lstitemVendors);
	}
	else
	{
		listitem=ldriver.findElement(listitemGuest);
	}
	
	listitem.click();
	Thread.sleep(3000);
		
	   
	    // JavascriptExecutor js = (JavascriptExecutor)ldriver;
	   // js.executeScript("arguments[2].click();",listitem );
	}     
	
	public void setGender(String gender ) {
		
		if(gender.equals("Male")) {
			ldriver.findElement(rdMaleGender).click();
			
		}
		else if(gender.equals("female")) {
			ldriver.findElement(rdFeMaleGender).click();
		}
		else
		{
			ldriver.findElement(rdMaleGender).click();//default
		}
		
	}
	
	public void setDob(String dob) {
		ldriver.findElement(txtDob).sendKeys(dob);
	}
	
	public void companyName(String cname) {
		ldriver.findElement(txtCompany).sendKeys(cname);
	}
	
	public void isTxexempt() {
		ldriver.findElement(isTaxexempt).click();
	}
	
	public void setMangerofVendor(String value) {
		
		Select drpdwn = new Select(ldriver.findElement(By.id("VendorId")));
		//drpdwn.selectByVisibleText(value);
		drpdwn.selectByIndex(2);
	
	}
	
	public void active() {
		ldriver.findElement(activeCheckbtn).click();
	}
	
	public void setAdminComment(String admin) {
		ldriver.findElement(adminComment).sendKeys(admin);
		
	}
	
	
	public void clickOnSave() {
		ldriver.findElement(saveBtn).click();
	}

	

	
	
	
	

	

	

}
