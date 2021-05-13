package TestRunners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//Test runner runs through TestNG - all the commented lines are no longter needed by the Testng and new importes got imported

//import org.junit.runner.RunWith;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		
features="C:\\Users\\tanmkoda\\OneDrive - Capgemini\\Desktop\\Gherkin-BDD-7\\BddFrameworkGherkin\\FeatureFiles", 
glue= {"stepDefininitions"},tags= "@One"
,monochrome = true,
plugin = { "pretty", "html:target/HTMLReport/HTMLREPORT.html",
"junit:target/JunitReport/report.xml",
"json:target/cucumber.json"}
 
)

public class LoginRunner2 extends AbstractTestNGCucumberTests{
	
	   // @Override
	    //@DataProvider(parallel = true)
	    //public Object[][] scenarios() {
	    	//return super.scenarios();
	    //}
	}




//Login2.feature