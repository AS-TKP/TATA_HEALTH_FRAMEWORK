package tata_health_ObjectRepository.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddDoctorSpecializationPage {
WebDriver driver;
public AddDoctorSpecializationPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
@FindBy(name="doctorspecilization")
private WebElement 	DoctorSpecializationEdit;

@FindBy(name="submit")
private WebElement SubmitButton;

@FindBy(xpath = "//span[text()=' Doctors ']")
private WebElement DoctorsButton;

@FindBy(xpath = "//span[text()=' Add Doctor']")
private WebElement AddDoctorButton;

public WebElement getDoctorsButton() {
	return DoctorsButton;
}

public WebElement getAddDoctorButton() {
	return AddDoctorButton;
}

public WebElement getDoctorSpecializationEdit() {
	return DoctorSpecializationEdit;
}

public WebElement getSubmitButton() {
	return SubmitButton;
}


}
