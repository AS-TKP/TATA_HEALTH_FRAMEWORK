package tata_health_generic_FilieUtility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {
public String getDataFromJsonFile(String key) throws Throwable {
	JSONParser jp = new JSONParser();
	Object obj = jp.parse(new FileReader("./src/main/resources/TATA_HEALTH_JSON_DATA.json"));
	JSONObject jObject = (JSONObject) obj;
	String Data = (String)jObject.get(key);
	return Data;
	
}
}
