package tata_health_ObjectRepository.POM;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tata_health_generic_BaseUtility.BaseClassTest;

public class Patient_UserSignUpPage extends BaseClassTest{

	WebDriver driver;

	public Patient_UserSignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='full_name']")
	private WebElement FullNameEdit;
	
	public WebElement getFullNameEdit() {
		return FullNameEdit;
	}
	
	@FindBy(name = "address")
	private WebElement AddressEdit;
	public WebElement getAddressEdit() {
		return AddressEdit;
	}
	
	@FindBy(name = "city")
	private WebElement CityEdit;
	public WebElement getCityEdit() {
		return CityEdit;
	}
	
	@FindBy(xpath = "//label[contains(.,'Female')]")
	private WebElement FemaleRadioBtn;
	public WebElement getFemaleRadioBtn() {
		return FemaleRadioBtn;
	}
	
	@FindBy(xpath = "//label[@for='rg-male']")
	private WebElement MaleRadioBtn;
	public WebElement getMaleRadioBtn() {
		return MaleRadioBtn;
	}
	
	@FindBy(id = "email")
	private WebElement EmailEdit;
	public WebElement getEmailEdit() {
		return EmailEdit;
	}
	
	@FindBy(id = "password")
	private WebElement PasswordEdit;
	
	public WebElement getPasswordEdit() {
		return PasswordEdit;
	}
	
	@FindBy(id = "password_again")
	private WebElement ConfirmPwdEdit;
	
	public WebElement getConfirmPwdEdit() {
		return ConfirmPwdEdit;
	}
	
	@FindBy(xpath = "//label[@for='agree']")
	private WebElement IagreeCheckBox;
	
	public WebElement getIagreeCheckBox() {
		return IagreeCheckBox;
	}
	
	@FindBy(partialLinkText = "Log-in")
	private WebElement LoginLink;
	
	public WebElement getLoginLink() {
		return LoginLink;
	}
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement SubmitButton;
	
	public WebElement getSubmitButton() {
		return SubmitButton;
	}
	
	public void BackToPatientLoginPage() {
		LoginLink.click();
	}

	public void Patient_UserSignUpForFemale(String SignUpUrl, String FullName, String Address, String City, String Email,
			String Password) throws Throwable {
		
		driver.get(SignUpUrl);
		FullNameEdit.sendKeys(FullName);
		AddressEdit.sendKeys(Address);
		CityEdit.sendKeys(City);
		FemaleRadioBtn.click();
		EmailEdit.sendKeys(Email);
		PasswordEdit.sendKeys(Password);
		ConfirmPwdEdit.sendKeys(Password);
		Actions act = new Actions(driver);
		act.scrollByAmount(200, 200).build().perform();
		act.moveToElement(SubmitButton).click().perform();
		Thread.sleep(3);
		Alert ale = driver.switchTo().alert();
		ale.accept();
	}

	public void Patient_UserSignUpForMale(String FullName, String Address, String City, String Email, String Password) throws Throwable {
		FullNameEdit.sendKeys(FullName);
		AddressEdit.sendKeys(Address);
		CityEdit.sendKeys(City);
		MaleRadioBtn.click();
		EmailEdit.sendKeys(Email);
		PasswordEdit.sendKeys(Password);
		ConfirmPwdEdit.sendKeys(Password);
		Actions act = new Actions(driver);
		act.scrollByAmount(200, 200).build().perform();
		act.moveToElement(SubmitButton).click().perform();
		Thread.sleep(5);
		Alert ale = driver.switchTo().alert();
		ale.accept();
	}
}
