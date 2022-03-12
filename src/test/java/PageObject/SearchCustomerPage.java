package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {

	public WebDriver ldriver;
	public SearchCustomerPage(WebDriver rdriver)
	{
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	
	@FindBy(how = How.ID, using = "SearchEmail")
	@CacheLookup
	WebElement txtEmail;
	
	
	@FindBy(how =How.ID, using = "search-customers")
	@CacheLookup
	WebElement btnSearch;

	@FindBy(how = How.XPATH , using ="//div/table[@role='grid']")
	@CacheLookup
	 WebElement tblsearchResult; 
	
	@FindBy(how = How.XPATH , using ="//table[@id='customers-grid']")
	@CacheLookup
	 WebElement table; 
	
	@FindBy(how = How.XPATH , using ="//table[@id='customers-grid']//tbody/tr")
	@CacheLookup
	 List<WebElement> tableRows; 
	
	
	@FindBy(how = How.XPATH , using ="//table[@id='customers-grid']//tbody/tr/td")
	@CacheLookup
	 List<WebElement> tablecolumns; 
	
	
	
	// action method
	
	
	public void setEmail(String email) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
		
		
	}
	
	
	
	public void clickSearch() {
		btnSearch.click();
	}
	
	
	public int getNoOfRow() {
		return (tableRows.size());
	}
	
	public int getNoOfColoum() {
		return (tablecolumns.size());
	}
	
	
	public boolean searchCustomerByEmail(String email) {
		
		
		boolean flag = false;
		for(int i=1;i<=getNoOfRow();i++) {
			
			String emailID =table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i +"]/td[2]")).getText();
			
			System.out.println(emailID);
			
			
			if(emailID.equals(email)) {
				flag = true;
				break;
			}
		}
		return flag;
		
		
	}
	
}
