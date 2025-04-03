package tata_health_generic_ListenerUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	int count = 0;
	int maxCount = 3;
	
	public boolean retry(ITestResult result) {
		if(count<maxCount) {
			count++;
			return true;
		}
		return false;
	}
}
