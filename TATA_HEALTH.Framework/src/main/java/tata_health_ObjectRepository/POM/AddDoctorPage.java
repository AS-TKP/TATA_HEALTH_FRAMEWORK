package tata_health_ObjectRepository.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddDoctorPage {
	WebDriver driver;

	public AddDoctorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "Doctorspecialization")
	private WebElement DoctorspecializationDD;

	@FindBy(name = "docname")
	private WebElement DoctorNameEdit;

	@FindBy(name = "clinicaddress")
	private WebElement DoctorClinicAddressEdit;

	@FindBy(name = "docfees")
	private WebElement DoctorConsultancyFeesEdit;

	@FindBy(name = "doccontact")
	private WebElement DoctorContactEdit;

	@FindBy(id = "docemail")
	private WebElement DoctorEmailEdit;

	@FindBy(name = "npass")
	private WebElement PasswordEdit;

	@FindBy(name = "cfpass")
	private WebElement ConfirmPasswordEdit;

	@FindBy(id = "submit")
	private WebElement SubmitButton;

	public WebElement getDoctorspecializationDD() {
		return DoctorspecializationDD;
	}

	public WebElement getDoctorNameEdit() {
		return DoctorNameEdit;
	}

	public WebElement getDoctorClinicAddressEdit() {
		return DoctorClinicAddressEdit;
	}

	public WebElement getDoctorConsultancyFeesEdit() {
		return DoctorConsultancyFeesEdit;
	}

	public WebElement getDoctorContactEdit() {
		return DoctorContactEdit;
	}

	public WebElement getDoctorEmailEdit() {
		return DoctorEmailEdit;
	}

	public WebElement getPasswordEdit() {
		return PasswordEdit;
	}

	public WebElement getConfirmPasswordEdit() {
		return ConfirmPasswordEdit;
	}

	public WebElement getSubmitButton() {
		return SubmitButton;
	}

}
