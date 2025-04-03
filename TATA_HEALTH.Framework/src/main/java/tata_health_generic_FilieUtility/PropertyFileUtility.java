package tata_health_generic_FilieUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtility {
	public String getDatafromPropertiesFile(String Key) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/main/resources/AdminLoginCD.properties");
		Properties Pobj = new Properties();
		Pobj.load(fis);
		String Data = Pobj.getProperty(Key);
		return Data;
	}
}
