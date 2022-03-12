package stepDefination;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObject.LoginPage;
import PageObject.addCustomerPage;

public class BaseClass {
	
	public WebDriver driver;
	public LoginPage lp;
	public addCustomerPage addcust;
	public static Logger logger;
	public Properties configProp;
	
	
	
	public static String randomstring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}


}
