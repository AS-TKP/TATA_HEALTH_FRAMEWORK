package tata_health_ObjectRepository.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UserEditProfilePage {
	WebDriver driver;

	public UserEditProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "fname")
	private WebElement UserNameEdit;

	@FindBy(name = "address")
	private WebElement AddressEdit;

	@FindBy(name = "city")
	private WebElement CityEdit;

	@FindBy(name = "gender")
	private WebElement GenderDD;

	@FindBy(xpath = "//option[text()='Male']")
	private WebElement MaleOption;

	@FindBy(xpath = "//option[text()='Female']")
	private WebElement FemaleOption;

	@FindBy(xpath = "//option[text()='Other']")
	private WebElement OtherOption;

	@FindBy(name = "submit")
	private WebElement UpdateButton;

	public WebElement getUserNameEdit() {
		return UserNameEdit;
	}

	public WebElement getAddressEdit() {
		return AddressEdit;
	}

	public WebElement getCityEdit() {
		return CityEdit;
	}

	public WebElement getGenderDD() {
		return GenderDD;
	}

	public WebElement getMaleOption() {
		return MaleOption;
	}

	public WebElement getFemaleOption() {
		return FemaleOption;
	}

	public WebElement getOtherOption() {
		return OtherOption;
	}

	public WebElement getUpdateButton() {
		return UpdateButton;
	}

	public void SelectGenderAsMale() {
		GenderDD.click();
		Select sel = new Select(MaleOption);
		sel.selectByVisibleText("Male");
	}

	public void SelectGenderAsFemale() {
		GenderDD.click();
		Select sel = new Select(FemaleOption);
		sel.selectByVisibleText("Female");
	}

	public void SelectGenderAsOther() {
		GenderDD.click();
		Select sel = new Select(OtherOption);
		sel.selectByVisibleText("Other");
	}
}
