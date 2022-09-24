package StepDefinition;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;

/*Parent Class*/
public class BaseClass {
	public	WebDriver driver;
	public	LoginPage loginpg;
	public AddNewCustomerPage  addNewCustPg;
	public SearchCustomerPage searchCustpg;
	public static Logger log;
	public ReadConfig readConfig;
	
	public String generateEmailId()
	{
		return (RandomStringUtils.randomAlphabetic(5));
	}
	
	

}
