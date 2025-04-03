package tata_health_ObjectRepository.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPatientPage {
	WebDriver driver;

	public AddPatientPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "patname")
	private WebElement PatientNameEdit;

	@FindBy(name = "patcontact")
	private WebElement PatientContactEdit;

	@FindBy(name = "patemail")
	private WebElement PatientEmailEdit;

	@FindBy(xpath = "//label[contains(.,'Female')]")
	private WebElement FemaleRadioButton;

	@FindBy(xpath = "//label[@for='rg-male']")
	private WebElement MaleRadioButton;

	@FindBy(name = "pataddress")
	private WebElement PatientAddressEdit;

	@FindBy(name = "patage")
	private WebElement PatientAgeEdit;

	@FindBy(name = "medhis")
	private WebElement MedicalHistoryEdit;

	@FindBy(id = "submit")
	private WebElement AddButton;

	public WebElement getPatientNameEdit() {
		return PatientNameEdit;
	}

	public WebElement getPatientContactEdit() {
		return PatientContactEdit;
	}

	public WebElement getPatientEmailEdit() {
		return PatientEmailEdit;
	}

	public WebElement getFemaleRadioButton() {
		return FemaleRadioButton;
	}

	public WebElement getMaleRadioButton() {
		return MaleRadioButton;
	}

	public WebElement getPatientAddressEdit() {
		return PatientAddressEdit;
	}

	public WebElement getPatientAgeEdit() {
		return PatientAgeEdit;
	}

	public WebElement getMedicalHistoryEdit() {
		return MedicalHistoryEdit;
	}

	public WebElement getAddButton() {
		return AddButton;
	}
	
	@FindBy(xpath = "//span[text()=' Patients ']")
	private WebElement PatientsButton;

	@FindBy(xpath = "//span[text()=' Manage Patient ']")
	private WebElement ManagePatientButton;

	public WebElement getPatientsButton() {
		return PatientsButton;
	}

	public WebElement getManagePatientButton() {
		return ManagePatientButton;
	}
	
	
	
	
	
	
	
	
	
}
