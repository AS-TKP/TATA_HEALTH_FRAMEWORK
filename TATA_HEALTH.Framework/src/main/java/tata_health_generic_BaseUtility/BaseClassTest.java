package tata_health_generic_BaseUtility;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import tata_health_generic_DataBaseUtility.DatabaseUtility;
import tata_health_generic_FilieUtility.ExcelUtility;
import tata_health_generic_FilieUtility.JavaUtility;
import tata_health_generic_FilieUtility.PropertyFileUtility;
import tata_health_generic_ListenerUtility.UtilityClassObject;
import tata_health_generic_WebDriverUtility.WebDriverUtility;

public class BaseClassTest extends WebDriverUtility {
	public DatabaseUtility dlib = new DatabaseUtility();
	public ExcelUtility elib = new ExcelUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public PropertyFileUtility pflib = new PropertyFileUtility();

	public WebDriver driver = null;
	public static WebDriver Sdriver = null;
	//it wont participate in parallel execution due to static modifier so create a localThread for multiple objects

	@BeforeSuite(groups = { "SmokeTest", "IntegrationTest", "SystemTest" })
	public void configBS() throws Throwable {
		dlib.getDbConnection();
	}
//	@Parameters("BROWSER")
//	@BeforeClass(groups = { "SmokeTest", "IntegrationTest", "SystemTest" })
//	public void configBC(String browser) throws Throwable {
//		/* launch browser */
//		String BROWSER = browser;
//		// pflib.getDatafromPropertiesFile("browser");
//
//		if (BROWSER.equals("chrome")) {
//			driver = new ChromeDriver();
//		} else if (BROWSER.equals("firefox")) {
//			driver = new FirefoxDriver();
//		} else if (BROWSER.equals("edge")) {
//			driver = new EdgeDriver();
//		} else {
//			driver = new ChromeDriver();
//		}
//		Sdriver = driver;
//		UtilityClassObject.setDriver(driver);//in order to create multiple objects
//	}

	@BeforeClass(groups= {"SmokeTest", "IntegrationTest", "SystemTest"})
	public void configBC() throws Throwable {
		/* launch browser */
		String BROWSER = pflib.getDatafromPropertiesFile("browser");

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		Sdriver = driver;
		UtilityClassObject.setDriver(driver);//in order to create multiple objects
	}

	@BeforeMethod(groups = { "SmokeTest", "IntegrationTest", "SystemTest" })
	public void configBM() throws Throwable {
		driver.manage().window().maximize();
		waitForPageToLoad(driver);
//   	String URL = pflib.getDatafromPropertiesFile("url");
//		String USERNAME = pflib.getDatafromPropertiesFile("username");
//		String PASSWORD = pflib.getDatafromPropertiesFile("password");
//		AdminLoginPage Alp = new AdminLoginPage(driver);
//		Alp.loginToAdminPanel(URL, USERNAME, PASSWORD);
		System.out.println("Login");
	}

	@AfterMethod(groups = { "SmokeTest", "IntegrationTest", "SystemTest" })
	public void configAM() {
		// AdminDashBoardPage Adbp = new AdminDashBoardPage(driver);
		// Adbp.AdminLogout();
		System.out.println("Logout");
	}

	@AfterClass(groups = { "SmokeTest", "IntegrationTest", "SystemTest" })
	public void configAC() {
		driver.quit();
	}

	@AfterSuite(groups = { "SmokeTest", "IntegrationTest", "SystemTest" })
	public void configAS() throws Throwable {
		dlib.closeDbConnection();
	}

}
