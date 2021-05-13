# V7 Cucumber &Maven 
*********reference*****************

Video to attach screenshots to reports

https://www.youtube.com/watch?v=6ic95TgkcEY&t=195s

********************
Remember*****************

***if your TestRunner File doesnt start with test word it will not be recognized by Maven
so in this case you need to include that file in the pom as in the example below
*** if your json file has different location thatn target/cucumber.json 
add additional tags in the maven plugin as:
<jsonFiles>
 <param>**/*cucumber.json</param>
</jsonFiles>

so that allow to find your json - based on that json you get the report

However I think the output and input is mention in the 2 lines above mention tags 
<outputDirectory>${project.build.directory}/cucumber-report-html</outputDirectory>
	<cucumberOutput>${project.build.directory}/cucumber.json</cucumberOutput>
	
	sec line need to match the json plugin location mention in the Runner class 
								
********************************************
To do that we need 2 plugins :]
-Maven Compiler plugin (allows to cleaan, run etc . project - we will find out all sets of all the new commands for that)
- Maven serefire plugin - which generate 2 version of reports - used in test phase to execute unit tests of application
	(*txt report , *.xml report) - => by default created at location ${basedir/target/selfire-reports}
	
	in the pom file we ad on top tags<build></build> inside <plugins></plugins>then inside <plugin></plugin> and inside the plugin we add those dependencies.
	Dependecy tags needs to be removed
	
	
	Below I attached my existing pom plugin part from my file : 
	maven - reporting will be used later for reporting (or it was already) - important part is that if you will call your feature without "Test" in it then your feature file will not be executed and you will receive error - 
	for that reason I attached  include tag in the maven-surefire-plugin which specify that my featutere file will run those tests,
	So i recommend you to call you feature file as TestRunner or word test include on fron of you feature file name
	example:
	
	<plugins>
		<plugin>
		<groupId>org.apache.maven.plugins</groupId>
   		 <artifactId>maven-compiler-plugin</artifactId>
   		 <version>3.8.1</version>
		 <configuration> 
                <source>1.8</source>
                <target>1.8</target>
            </configuration>
		</plugin>
		<plugin>
		 <groupId>org.apache.maven.plugins</groupId>
  		  <artifactId>maven-surefire-plugin</artifactId>
  		  <version>2.22.0</version>
  		   <configuration>
                <includes>
                    <include>**/*LoginRunner.java</include>
                </includes>
			<testFailureIgnore>true</testFailureIgnore>
		  </configuration> 
		</plugin>
		<plugin>
	 
    		<groupId>net.masterthought</groupId>
   			 <artifactId>maven-cucumber-reporting</artifactId>
    			<version>2.8.0</version>
 
						<executions>
							<execution>
								<id>executions</id>
								<phase>verify</phase>
								<goals>
								<goal>generate</goal>
								</goals>
								<configuration>
								<projectName>GherkinBDD</projectName>
								<outputDirectory>${project.build.directory}/cucumber-report-html</outputDirectory>
								<cucumberOutput>${project.build.directory}/cucumber.json</cucumberOutput>
								<jsonFiles>
         							 <param>**/*cucumber.json</param>
     							</jsonFiles>
								</configuration>
							</execution>
					</executions> 
			</plugin>
	</plugins>

*************************************************************
-clean – usuwa folder target, czyli skompilowany kod
-validate – waliduje projekt i sprawdza obecność wszystkich potrzebnych informacji do kompilacji
-compile – kompiluje kod projektu
-test – kompiluje i uruchamia testy jednostkowe
-package – kompiluje i pakuje kod do zadanego formatu, na przykład *.jar, czyli tworzy tzw. paczkę dystrybucyjną
-verify – uruchamia „check” zdefiniowany w projekcie w celu sprawdzenia czy utworzona paczka dystrybucyjna jest poprawna
-install – instaluje paczkę dystrybucyjną do lokalnego repozytorium, tak aby inne projekty mogły z niego korzystać
-site – generuje dokumentację projektu
-deploy – kopiuje ostateczną paczkę projektu do zdalnego repozytorium

Poszczególne fazy mogą być od siebie zależne. Na przykład wywołanie komendy deploy będzie wymagać wcześniejszego utworzenia paczki dystrybucyjnej.
W ostatnim akapicie pojawiły nam się takie zwroty jak paczka dystrybucyjna, repozytorium. Należy je sobie wytłumaczyć.

Paczka dystrybucyjna to skompilowany i zbudowany kod w formie na przykład pliku *.jar, *.war lub innego w zależności od ustawień projektu. Większość projektów javowych typu open source jest w ten sposób dystrybuowana przez Internet.

Repozytorium zaś to nic innego jak zbiór plików dystrybucyjnych składających się z wielu artefaktów (plików) w różnych wersjach. Jednym z takich artefaktów jest na przykład Selenium czy TestNG, którego będziemy używać. Repozytoria można podzielić na:

Lokalne – przykładem takiego repozytorium jest nasz komputer, na którym mamy zainstalowanego Mavena. Jeśli na takim komputerze uruchomimy teraz kod źródłowy, którego projekt będzie projektem mavenowym z komendą „install”, to u nas na komputerze zostanie utworzona paczka tego projektu oraz zainstalowana do naszego lokalnego repozytorium.
Zdalne – są to repozytoria w Internecie, z reguły ogólnodostępne. Przykładem takiego repozytorium jest https://mvnrepository.com/. Innym przykładem może być repozytorium firmowe.
Jest to tylko wstęp do Mavena. Jeśli chcesz dowiedzieć się więcej zapoznaj się z oficjalną dokumentacją Mavena dostępną pod adresem: http://maven.apache.org/guides/


Make sure that you test runner file looks like that
RunWith(Cucumber.class)
@CucumberOptions(
		
features="C:\\Users\\kgajdosz\\Documents\\bench learning\\BDD\\Gherkin-Cucumber\\BddFrameworkGherkin\\FeatureFiles", 
glue= {"stepDefininitions"},tags= "@One"
,monochrome = true,
plugin = { "pretty", 
"html:target/HTMLReport-NEW/HTMLREPORT.html",
"junit:target/JunitReport/report.xml",
"json:target/cucumber.json"}

******     "json:target/cucumber.json"}  ***** that part is important because the maven report is searching for that Json to make that html json format
*************************************Steps******************************



First run 
		mvn clean install in the cmd

Sec step run 	
			mvn clean verify   or mvn verify -DSkipTests
			

*****************************************************TestNG***********************************************************
## Test NG is included in the branch 
We will try to add that framework to our project: 

1) the main thing is to extends our TestRunner class with: AbstractTestNGCucumberTests - but then we can remove attribute @RunWith
Once that is done we need to make sure that TestNG & Cucumber TestNG  dependencies are added to that project

Below you will find working dependencies on my project
  
  
  <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>BddGroup</groupId>
  <artifactId>BddFrameworkGherkin</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <packaging>jar</packaging>

  <name>BddFrameworkGherkin</name>
  <url>http://maven.apache.org</url>

<properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
	 <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
     <maven.compiler.target>1.8</maven.compiler.target>
 	 <maven.compiler.source>1.8</maven.compiler.source>
 
  </properties>

<build>
	<plugins>
		<plugin>
		<groupId>org.apache.maven.plugins</groupId>
   		 <artifactId>maven-compiler-plugin</artifactId>
   		 <version>3.8.1</version>
		 <configuration> 
                <source>1.8</source>
                <target>1.8</target>
            </configuration>
		</plugin>
		<plugin>
		 <groupId>org.apache.maven.plugins</groupId>
  		  <artifactId>maven-surefire-plugin</artifactId>
  		  <version>2.22.0</version>
  		   <configuration>
                <includes>
                    <include>**/*LoginRunner.java</include>
                </includes>
			<testFailureIgnore>true</testFailureIgnore>
		  </configuration> 
		</plugin>
		<plugin>
	 
    		<groupId>net.masterthought</groupId>
   			 <artifactId>maven-cucumber-reporting</artifactId>
    			<version>2.8.0</version>
 
						<executions>
							<execution>
								<id>executions</id>
								<phase>verify</phase>
								<goals>
								<goal>generate</goal>
								</goals>
								<configuration>
								<projectName>GherkinBDD</projectName>
								<outputDirectory>${project.build.directory}/cucumber-report-html</outputDirectory>
								<cucumberOutput>${project.build.directory}/cucumber.json</cucumberOutput>
								</configuration>
							</execution>
					</executions> 
			</plugin>
	</plugins>
</build>
  
 <dependencies>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.141.59</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-server -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-server</artifactId>
            <version>3.141.59</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-java -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>6.9.1</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-junit -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
             <version>6.9.1</version>
            <scope>test</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-core -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-core</artifactId>
             <version>6.9.1</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-jvm-deps -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-jvm-deps</artifactId>
            <version>1.0.6</version>
            <scope>provided</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/io.cucumber/gherkin -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>gherkin</artifactId>
            <version>15.0.2</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager -->

        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>4.3.1</version>
            <scope>test</scope>
        </dependency>
      
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/info.cukes/cucumber-picocontainer -->
		<dependency>
   		 <groupId>info.cukes</groupId>
   		 <artifactId>cucumber-picocontainer</artifactId>
    		<version>1.2.4</version>
    		<scope>test</scope>
		</dependency>
        
		
		<!-- https://mvnrepository.com/artifact/info.cukes/cucumber-testng -->
<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-testng -->
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-testng</artifactId>
    <version>6.9.1</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.testng/testng -->
<!-- https://mvnrepository.com/artifact/org.testng/testng -->
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
       <version>6.14.2</version>
    <scope>test</scope>
</dependency>


    </dependencies>

</project>
  
  
  
  ************************************************ File example below ************************
    
    
    
  make changes to the Test Runner class as below:
package TestRunners;

//import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import cucumber.api.CucumberOptions;
 
// That test runner can be run by TestNG
//@RunWith(Cucumber.class)
@CucumberOptions(
		
features="C:\\Users\\kgajdosz\\Documents\\bench learning\\BDD\\Gherkin-Cucumber\\BddFrameworkGherkin\\FeatureFiles", 
glue= {"stepDefininitions"},tags= "@One"
,monochrome = true,
plugin = { "pretty", "html:target/HTMLReport/HTMLREPORT.html",
"junit:target/JunitReport/report.xml",
"json:target/JsonReport/report.json"}
 
)

public class LoginRunner2 extends AbstractTestNGCucumberTests{

}

***************************** test ng xml

we can convert esisting project to testng project - right click on the project and click TestNG > Convert to testNG
Testng.xml will be created - you might need to modify it - > just like example below:
Once the changes are done - right click opn the xml file and run as testn ng test

More modification to that XML we will do in the future branches - so we can modify them and make our test paralell


<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >

<suite name="Suite" verbose="1" configfailurepolicy="skip">
  <test name="Test">  
  	<classes>
  		<class name ="TestRunners.LoginRunner2"/>
 	 </classes>
  </test> 
</suite> <!-- Suite -->




Don't forget to click on test runner (right click) and select testNG option and then convert it to TestNG - so TestNG.xml will be created 
Inside that file we can manipulate how our test will be run (parallel / different suits etc.)

In the next branch we 

*********************************************PROPERTIES FILE**********************************************************************

Properties tags added to specify compiler
addidtional include tag attached in the surfire plugin in case you will get only BUILD message during mvn test (testing) process

Once you finish the test using maven - you can find results in the \target\cucumber-report-html\cucumber-html-reports\feature-overview.html location


******************************************Properties Files addded to remove final message right after test is done*******************************

Numbers of times we receive the message after we complete the test - to remove that message we create additional file in the s
cr/test/resources called:
"cucumber.properties" and inside we type:

cucumber.publish.quiet=true
# That feature allows you to remove final wording in the execution windows - after test is completed - last window

save it and enjoy







