package quickstart.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Constants.TimeOuts;

public class GoogleSearchPage  {

	WebDriver driver;

	@FindBy(xpath="//img[@alt=\"Google\"]")
    WebElement googleLogo;
	
    @FindBy(xpath="//input[@name='q']")
    WebElement searchBox;
	
    @FindBy(xpath="//div[@class='g']//h3/span")
    WebElement firstResult;
    

	public GoogleSearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean assertValues(String actual, String expected) {
		if(actual.equals(expected)){
			return true;
		} else 
			return false;
	}
	
	
	public void enterKeyWord(String keyword) {
		
		searchBox.sendKeys(keyword);
		searchBox.sendKeys(Keys.ENTER);
	}
	
	public  void searchKeyword(String keyword) {
		
		this.enterKeyWord(keyword);
		this.waitForResultLink(keyword);			
	}
	public void waitForResultLink(String keyword) {
		String searchResultLink="//h3[contains(.,'"+keyword+"')]";
		WebDriverWait wait= new WebDriverWait(driver, TimeOuts.DEFAULT_TIMEOUT);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(searchResultLink)));		
	}

}
