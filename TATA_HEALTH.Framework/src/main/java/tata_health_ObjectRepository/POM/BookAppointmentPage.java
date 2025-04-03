package tata_health_ObjectRepository.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookAppointmentPage {
WebDriver driver;
public BookAppointmentPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
@FindBy(name="Doctorspecialization")
private WebElement DoctorspecializationDD;

@FindBy(id="doctor")
private WebElement DoctorDD;

@FindBy(name="appdate")
private WebElement DateEdit;

@FindBy(id="timepicker1")
private WebElement TimeEdit;

@FindBy(name="submit")
private WebElement SubmitButton;

public WebElement getDoctorspecializationDD() {
	return DoctorspecializationDD;
}

public WebElement getDoctorDD() {
	return DoctorDD;
}

public WebElement getDateEdit() {
	return DateEdit;
}

public WebElement getTimeEdit() {
	return TimeEdit;
}

public WebElement getSubmitButton() {
	return SubmitButton;
}


}
