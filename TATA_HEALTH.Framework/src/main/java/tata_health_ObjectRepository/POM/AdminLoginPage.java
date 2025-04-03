package tata_health_ObjectRepository.POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tata_health_generic_WebDriverUtility.WebDriverUtility;

public class AdminLoginPage extends WebDriverUtility{
	WebDriver driver;

	public AdminLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	private WebElement UsernameEdit;
	public WebElement getUsernameEdit() {
		return UsernameEdit;
	}
	
	@FindBy(name = "password")
	private WebElement PasswordEdit;
	public WebElement getPasswordEdit() {
		return PasswordEdit;
	}
	
	@FindBy(name = "submit")
	private WebElement LoginButton;
	public WebElement getLoginButton() {
		return LoginButton;
	}
	
	@FindBy(partialLinkText = "Create an account")
	private WebElement CreateAnAccountLink;
	public WebElement getCreateAnAccountLink() {
		return CreateAnAccountLink;
	}

	public void loginToAdminPanel(String URL, String UN, String PWD) {
        
		driver.get(URL);
		UsernameEdit.sendKeys(UN);
		PasswordEdit.sendKeys(PWD);
		LoginButton.click();
	}

	public void loginToAdminPanel(String UN, String PWD) {
		
		UsernameEdit.sendKeys(UN);
		PasswordEdit.sendKeys(PWD);
		LoginButton.click();
	}
}
