package tata_health_ObjectRepository.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportsBetweenDatesPage {
WebDriver driver;
public ReportsBetweenDatesPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

@FindBy(id= "")
private WebElement FromDateEdit; 

@FindBy(id= "todate")
private WebElement ToDateEdit; 

@FindBy(id= "submit")
private WebElement SubmitButton;

public WebElement getFromDateEdit() {
	return FromDateEdit;
}

public WebElement getToDateEdit() {
	return ToDateEdit;
}

public WebElement getSubmitButton() {
	return SubmitButton;
} 
}
