package tata_health_ObjectRepository.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPatientSearchPage {
WebDriver driver;
public AdminPatientSearchPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
@FindBy(id= "searchdata")
private WebElement PatientSearchBarEdit;

@FindBy(id= "submit")
private WebElement SearchButton;

public WebElement getPatientSearchBarEdit() {
	return PatientSearchBarEdit;
}

public WebElement getSearchButton() {
	return SearchButton;
}


}
