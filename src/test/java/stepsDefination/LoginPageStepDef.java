package stepsDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import core.AllDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;

public class LoginPageStepDef extends AllDriverManager{

//	public static WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@Given("User is on homepage")
	public void user_is_on_homepage() {
		WebDriverManager.chromedriver().setup();		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://tecorb.com");				
	}
    
    @When("^User navigates to login page$")
    public void user_navigates_to_login_page() throws Throwable {
        driver.findElement(By.id("exampleModal1")).click();
        driver.findElement(By.cssSelector("button[class='header_dropDownItem__FVrsu dropdown-item undefined ']")).click();
    }
    
    @When("^user enters username and Password$")
    public void user_enters_username_and_Password() throws Throwable {
        LoginPage lp = new LoginPage(driver);
        log("Enter username");
        lp.getUserName().sendKeys("ankesh@tecorb.co");
        log("Enter password");
        lp.getPassword().sendKeys("12345678");
        lp.getLoginBtn().click();
    }
    
    @When("I enter username as {string} and password as {string}")
    public void i_enter_username_as_and_password_as(String uname, String pwd) {
    	driver.findElement(By.name("email")).sendKeys(uname);
    	driver.findElement(By.name("password")).sendKeys(pwd);
      
    }
    
    @And("^User click on login button$")
    public void user_click_on_signin_btn() throws Throwable {
      driver.findElement(By.className("customeModal_sendBtn__9iKgN")).click();
     
  }
    @Then("I should see the alert message")
    public void i_should_see_the_alert_message() {
        driver.findElement(By.xpath("//p[text()='Unauthorized access']")).isDisplayed();
        driver.quit();
    }
   
      
}
