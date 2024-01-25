package genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementationClass implements IRetryAnalyzer {

	int limit = 2;
	int count = 0;
	
	public boolean retry(ITestResult result) {
		
		while(count<limit) {
			count ++;
			return true;
		}
		return false;
	}

}
