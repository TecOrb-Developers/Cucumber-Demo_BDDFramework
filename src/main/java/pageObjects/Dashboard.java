package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.AllDriverManager;

public class Dashboard extends AllDriverManager{
	
	public Dashboard(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "navbar-brand  header_navbarBrand__9fDgs")
	private WebElement  homepageLogo;
	
	@FindBy(className = "[object Object] undefined ")
	private WebElement shareVehicleBtn;
	
	@FindBy(id = "exampleModal1")
	private WebElement toolMenu;
	
	@FindBy(className = "header_dropDownItem__FVrsu dropdown-item undefined ")
	private WebElement logInLink;
	
	
	public boolean homepageIsDisplayed()
	{
		homepageLogo.isDisplayed();
		return true;	
	}

	public LoginPage clickOnLoginLink() {
		toolMenu.click();
		logInLink.click();
		return new LoginPage(driver);
	}

}
