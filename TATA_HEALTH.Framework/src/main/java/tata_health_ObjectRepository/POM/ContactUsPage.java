package tata_health_ObjectRepository.POM;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
	WebDriver driver;

	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "fullname")
	private WebElement FullNameEdit;

	public WebElement getFullNameEdit() {
		return FullNameEdit;
	}

	@FindBy(name = "emailid")
	private WebElement EmailEdit;

	public WebElement getEmailEdit() {
		return EmailEdit;
	}

	@FindBy(name = "mobileno")
	private WebElement MobileEdit;

	public WebElement getMobileEdit() {
		return MobileEdit;
	}

	@FindBy(name = "description")
	private WebElement DescriptionEdit;

	public WebElement getDescriptionEdit() {
		return DescriptionEdit;
	}

	@FindBy(name = "submit")
	private WebElement SubmitButton;

	public WebElement getSubmitButton() {
		return SubmitButton;
	}

	@FindBy(xpath = "//a[@href='index.html']")
	private WebElement HomeButton;

	public WebElement getHomeButton() {
		return HomeButton;
	}

	public void SendContactQuery(String Url, String FullName, String Email, String Mobile, String Description) throws Throwable {
		driver.get(Url);
		FullNameEdit.sendKeys(FullName);
		EmailEdit.sendKeys(Email);
		MobileEdit.sendKeys(Mobile);
		DescriptionEdit.sendKeys(Description);
		SubmitButton.click();
		
	}
}
