package tata_health_ObjectRepository.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "contact")
	private WebElement ContactButton;
	public WebElement getContactBtn() {
		return ContactButton;
	}

	@FindBy(linkText = "//a[@href='hms/user-login.php']")
	private WebElement PatientLoginLink;
	public WebElement getPatientLoginLink() {
		return PatientLoginLink;
	}

	@FindBy(linkText = "//a[@href='hms/doctor/']")
	private WebElement DoctorsLoginLink;
	public WebElement getDoctorsLoginLink() {
		return DoctorsLoginLink;
	}

	@FindBy(linkText = "//a[@href= 'hms/admin']")//a[@href= 'hms/admin']
	private WebElement AdminLoginLink;
	public WebElement getAdminLoginLink() {
		return AdminLoginLink;
	}

	public void PatientLoginpage() {
		PatientLoginLink.click();
	}
	public void DoctorLoginPage() {
		DoctorsLoginLink.click();
	}
	public void AdminLoginPage() {
		AdminLoginLink.click();
	}
	public void contactUsPage() {
		ContactButton.click();
	}
}
