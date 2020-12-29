package megastores;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry_Analyzer implements IRetryAnalyzer {
    
int minCount = 0;
    
int maxCount = 2;

@Override
public boolean retry(ITestResult result)
{

    if(minCount<=maxCount)
    {
        minCount++;
        System.out.println("Retrying Test method : "+result.getName() + " for " + minCount +" times. ");
        return true;
    }
    return false;
}
}
