package tata_health_ObjectRepository.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserChangePasswordPage {
	WebDriver driver;

	public UserChangePasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "cpass")
	private WebElement CurrentPasswordEdit;

	@FindBy(name = "npass")
	private WebElement NewPasswordEdit;

	@FindBy(name = "cfpass")
	private WebElement ConfirmPasswordEdit;

	@FindBy(name = "submit")
	private WebElement SubmitButton;

	public WebElement getCurrentPasswordEdit() {
		return CurrentPasswordEdit;
	}

	public WebElement getNewPasswordEdit() {
		return NewPasswordEdit;
	}

	public WebElement getConfirmPasswordEdit() {
		return ConfirmPasswordEdit;
	}

	public WebElement getSubmitButton() {
		return SubmitButton;
	}

}
