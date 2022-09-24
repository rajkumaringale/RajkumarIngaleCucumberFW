package StepDefinition;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.github.dockerjava.api.model.Driver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
public class StepDef extends BaseClass
{  
   @Before	
   public void setup()
   {   //initialise logger
	   log = LogManager.getLogger("StepDef");
	   System.out.println("Setup method executed..");
	   
	   readConfig = new ReadConfig();
	   
	   String browser = readConfig.getBrowser();
	   
	   switch(browser.toLowerCase())
	   {
	   case "chrome":
		   WebDriverManager.chromedriver().setup();
		   driver = new ChromeDriver();
		   break;
	   case "firefox":
		   WebDriverManager.firefoxdriver().setup();
		   driver = new FirefoxDriver();
		   break;
	   case "msedge":
		   WebDriverManager.edgedriver().setup();
		   driver = new EdgeDriver();
		   break;
		   default:
			   driver = null;
			   break;
	   }
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
   }

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		loginpg = new LoginPage(driver);
		addNewCustPg = new AddNewCustomerPage(driver);
		searchCustpg = new SearchCustomerPage(driver);
		}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
     driver.get(url);
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailadd, String passwordd) {
		loginpg.enterEmail(emailadd);
		loginpg.enterPassword(passwordd);
		
		log.info("Entered Email add and Password");
	}

	@When("Click on Login button")
	public void click_on_login_button() {
		loginpg.clickOnLoginButton();
		
		log.info("Click on Login Button");
	}
 ///////////////////Login Feature///////////////////////////
	
	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle)
	{
		String actualTitle = addNewCustPg.getPageTitle();
		
		if(actualTitle.equals(expectedTitle))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}

	}

	@When("User click on Logout button")
	public void user_click_on_logout_button() {
		
		loginpg.clickOnLogOutButton();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
   
	}

	@Then("Close browser")
	public void close_browser() {
		driver.close();
	//	driver.quit();

	}
	///////////////////Add New Customer//////////////////
	@Then("User can View Dashboard")
	public void user_can_view_dashboard() {
		String actualTitle = addNewCustPg.getPageTitle();
		String expectedTitle = "Dashboard / nopCommerce administration";

		if(actualTitle.equals(expectedTitle))
		    {
			
			Assert.assertTrue(true);
			}
		else
		{
			Assert.assertTrue(false);
		}
	}

	@When("User Click on Customers Menu")
	public void user_click_on_customers_menu()
    {
		addNewCustPg.clickOnCustomersMenu();
		    
	}
    @When("Click on Customers Menu Item")
	public void click_on_customers_menu_item() 
	{
    addNewCustPg.clickOnCustomersMenuItem();
	   
	}
    @When("Click on Add new button")
	public void click_on_add_new_button()
    {
		addNewCustPg.clickOnAddnew();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		String actualTitle = addNewCustPg.getPageTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";

		if(actualTitle.equals(expectedTitle))
		{
			//log.info("User can view Add new customer page- passed");

			Assert.assertTrue(true);//pass
		}
		else
		{
			//log.info("User can view Add new customer page- failed");

			Assert.assertTrue(false);//fail
		}
	    
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
		//addNewCustPg.enterEmail("Simple@gmail.com");
		addNewCustPg.enterEmail(generateEmailId() + "@gmail.com");
		addNewCustPg.enterPassword("raj1234");
		addNewCustPg.enterFirstName("Rajkumar");
		addNewCustPg.enterLastName("Ingale");
		addNewCustPg.enterGender("Male");
		addNewCustPg.enterDob("4/07/1995");
		addNewCustPg.enterCompanyName("QMS");
		addNewCustPg.enterAdminContent("Admin content");
		addNewCustPg.enterManagerOfVendor("Vendor 1");
	   
	}

	@When("Click on save button")
	public void click_on_save_button() {
		addNewCustPg.clickOnSave();
	}

	@Then("User can view confirmation Message {string}")
	public void user_can_view_confirmation_message(String exptectedConfirmationMsg) {
		String bodyTagText = driver.findElement(By.tagName("Body")).getText();
		if(bodyTagText.contains(exptectedConfirmationMsg))
		{
			Assert.assertTrue(true);//pass
		}
		else
		{
		 Assert.assertTrue(false);//fail
        }
	    }
	@When("Enter customer Email")
	public void enter_customer_email() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.navigate().refresh();
		searchCustpg.enterEmailAdd("victoria_victoria@nopCommerce.com");
	    
	}

	@When("Click on search button")
	public void click_on_search_button() {
		searchCustpg.clickonSearchButton();
	}

	@Then("User should found Email in the search table")
	public void user_should_found_email_in_the_search_table() {
	    String expectedEmai = "victoria_victoria@nopCommerce.com";
	    
	//    Assert.assertTrue(searchCustpg.searchCustomerByEmail(expectedEmai));
	    
	    if(searchCustpg.searchCustomerByEmail(expectedEmai) == true)
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    
	    	Assert.assertTrue(false);
	    }  
	    
	   }
///////////////////// search customer ////////////////////////////
	@When("Enter customer Firstname")
	public void enter_customer_firstname() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.navigate().refresh();
		searchCustpg.enterFirstName("Victoria");
	    
	}

	@When("Enter customer Lastname")
	public void enter_customer_lastname() {
		
		searchCustpg.enterLastName("Terces");
	    
	}

	@Then("User should found Name in the Search table")
	public void user_should_found_name_in_the_search_table() {
		String expectedName = "Victoria Terces";
	    
		//    Assert.assertTrue(searchCustpg.searchCustomerByName(expectedName));
		    
		    if(searchCustpg.searchCustomerByName(expectedName) == true)
		    {
		    	Assert.assertTrue(true);
		    }
		    else
		    {
		    
		    	Assert.assertTrue(false);
		    }  
	    
	}
	//To capture failed screenshot after execution of each scenario then we used @After
	/*@After
	public void teardown(Scenario sc)
	{
		if(sc.isFailed()==true)
		{   //Convert web driver object to TakesScreenshot
			String filewithpath = "C:\\Acceleration\\OctWorkSpace\\Automation_Practice_CucumberProject\\Screenshot\\failedsreenshot.png";
			TakesScreenshot srcShot = ((TakesScreenshot)driver);
			
			//Call getScreenshotAs method to create image file
			File SrcFile = srcShot.getScreenshotAs(OutputType.FILE);
			
			//Move image file to new destination
			File DestFile = new File(filewithpath);
			
			//Copy file at destination 
			try {
				FileUtils.copyFile(SrcFile, DestFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
		System.out.println("Tear Down method executed..");
		driver.quit();
	}*/
	//To capture screenshot after each step of scenario then we used @AfterStep
	@AfterStep
	public void addScreenshot(Scenario scenario)
	{   if(scenario.isFailed())
	{
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.getName());
	}
	
}
}

	

