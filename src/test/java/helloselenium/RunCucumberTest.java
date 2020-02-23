package helloselenium;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/helloselenium" ,plugin = {"pretty"})
public class RunCucumberTest {
	
	@BeforeClass
	public static void before() {
		System.setProperty("webdriver.chrome.driver",
				"..\\Chromedriver\\chromedriver.exe");
		
		Properties prop = new Properties();

		String env = System.getProperty("env", "newsite");
		

		
		try {
		    prop.load(new FileInputStream("src/test/resources/enviroments/"+env+"/config.properties"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		Set<String> keys = prop.stringPropertyNames();
	    for (String key : keys) {
	     
	      System.setProperty(key, prop.getProperty(key));
	    }


		
		
	}
	
	

}