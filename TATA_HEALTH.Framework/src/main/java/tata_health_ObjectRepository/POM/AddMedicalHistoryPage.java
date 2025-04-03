package tata_health_ObjectRepository.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddMedicalHistoryPage {
	WebDriver driver;

	public AddMedicalHistoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "bp")
	private WebElement BloodPressureEdit;

	@FindBy(name = "bs")
	private WebElement BloodSugarEdit;

	@FindBy(name = "weight")
	private WebElement WeightEdit;

	@FindBy(name = "temp")
	private WebElement BodyTempratureEdit;

	@FindBy(name = "pres")
	private WebElement PrescriptionEdit;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement SubmitButton;

	@FindBy(name = "//button[text()='Close']")
	private WebElement CloseButton;

	public WebElement getBloodPressureEdit() {
		return BloodPressureEdit;
	}

	public WebElement getBloodSugarEdit() {
		return BloodSugarEdit;
	}

	public WebElement getWeightEdit() {
		return WeightEdit;
	}

	public WebElement getBodyTempratureEdit() {
		return BodyTempratureEdit;
	}

	public WebElement getPrescriptionEdit() {
		return PrescriptionEdit;
	}

	public WebElement getSubmitButton() {
		return SubmitButton;
	}

	public WebElement getCloseButton() {
		return CloseButton;
	}

}
