package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.AllDriverManager;

public class LoginPage extends AllDriverManager{

	@FindBy(name = "email")
	private WebElement userName;
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(className = "customeModal_sendBtn__9iKgN")
	private WebElement loginBtn;
	
	
	public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
   }

	
	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	
//	public boolean loginModalDisplayed()
//	{
//		loginModal.isDisplayed();
//		userName.isDisplayed();
//		password.isDisplayed();
//		loginBtn.isDisplayed();
//		forgotPwdLink.isDisplayed();
//		signUpbtn.isDisplayed();
//		return true;	
//	}
	
}
