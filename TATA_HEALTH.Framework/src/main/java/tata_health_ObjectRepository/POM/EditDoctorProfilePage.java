package tata_health_ObjectRepository.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditDoctorProfilePage {
	WebDriver driver;

	public EditDoctorProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "Doctorspecialization")
	private WebElement DoctorSpecializationEdit;

	@FindBy(name = "docname")
	private WebElement DoctorNameEdit;

	@FindBy(name = "clinicaddress")
	private WebElement DoctorClinicAddressEdit;

	@FindBy(name = "docfees")
	private WebElement DoctorConsultancyFeesEdit;

	@FindBy(name = "doccontact")
	private WebElement DoctorContactEdit;

	@FindBy(name = "submit")
	private WebElement UpdateButton;

	public WebElement getDoctorSpecializationEdit() {
		return DoctorSpecializationEdit;
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

	public WebElement getUpdateButton() {
		return UpdateButton;
	}

}
