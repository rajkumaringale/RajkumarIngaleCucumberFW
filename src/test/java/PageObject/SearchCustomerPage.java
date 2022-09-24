package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {
	WebDriver ldriver;
	public SearchCustomerPage(WebDriver rDriver)
	{
		ldriver= rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(xpath="//input[@id='SearchEmail']")
	WebElement searchmail;
	@FindBy(xpath="//input[@id='SearchCompany']")
	WebElement searchcompny;
	@FindBy(xpath="//button[@id='search-customers']")
	WebElement clikonsearchbtn;
	@FindBy(xpath="//input[@id='SearchFirstName']")
	WebElement searchfirstname;
	@FindBy(xpath="//input[@id='SearchIpAddress']")
	WebElement searchipaddress;
	@FindBy(xpath="//input[@id='SearchLastName']")
	WebElement searchlastname;
	@FindBy(xpath="//div[@role='listbox']")
	WebElement searchcustomerrole;
	@FindBy(xpath="//table[@role='grid']")
	WebElement searchResult;
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;
	//@FindBy(xpath="//table[@id='customers-grid']//tbody/tr[1]/td")
	//List<WebElement> tableColoumns;
	
	public void enterEmailAdd(String emai)
	{
		searchmail.sendKeys(emai);
	}
	public void clickonSearchButton()
	{
		clikonsearchbtn.click();
	}
	public boolean searchCustomerByEmail(String email)
	{
		boolean found = false;
		int ttlRows = tableRows.size();
	//	int ttlColumns = tableColoumns.size();
		for(int i=1;i<=ttlRows;i++)
		{
			WebElement webElementEmail = ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i + "]/td[2]"));
		
            String actualemailAdd = webElementEmail.getText();	
		
		if(actualemailAdd.equals(email))
		{
			found= true;
		}
	}
	return found;
}
	////////////////search customer by name////////////////////////
	public void enterFirstName(String firstnameText)
	{
		searchfirstname.sendKeys(firstnameText);
	}
	public void enterLastName(String lastnameText)
	{
		searchlastname.sendKeys(lastnameText);
	}
	public boolean searchCustomerByName(String name)
	{
		boolean found = false;
		int ttlRows = tableRows.size();
	//	int ttlColumns = tableColoumns.size();
		for(int i=1;i<=ttlRows;i++)
		{
			WebElement webElementName = ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i + "]/td[3]"));
		
            String actualName = webElementName.getText();	
		
		if(actualName.equals(name))
		{
			found= true;
			break;
		}
	}
	return found;
}}