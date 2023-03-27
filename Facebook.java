package org.stepdefinitiion;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {
	
	/*

	//Two datas with header or two datas list not working properly
	WebDriver driver;
	
@Given("humanbeing facebook login page")
public void humanbeing_facebook_login_page() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
}

@When("humanbeing given datas username and password")
public void humanbeing_given_datas_username_and_password(io.cucumber.datatable.DataTable data) throws InterruptedException {
	
	List<Map<String, String>> asMaps = data.asMaps();
	
	for(Map<String, String> x:asMaps)
	{

		   driver.findElement(By.id("email")).sendKeys(x.get("username"));
		   driver.findElement(By.id("pass")).sendKeys(x.get("password"));
	}
	
}

@When("humanbeing submit the button")
public void humanbeing_submit_the_button() throws InterruptedException {
	WebElement login = driver.findElement(By.name("login"));
	login.click();
	Thread.sleep(2000);   
}

@Then("humanbeing go to unwanted page")
public void humanbeing_go_to_unwanted_page() {
	Assert.assertTrue(driver.getCurrentUrl().contains("?privacy_mutation_token"));
	System.out.println("navigated the invalid page");
	//driver.quit();  
}

}
	
*/

//---------------------------------------------------------------------------------------------------	
	/*
	
	//one data with header or one data list

	WebDriver driver;
@Given("person facebook login page")
public void person_facebook_login_page() {
	
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
}

@When("person given datas username and password")
public void person_given_datas_username_and_password(io.cucumber.datatable.DataTable dataTable) {
	
    Map<String, String> m = dataTable.asMap(String.class, String.class);
    driver.findElement(By.id("email")).sendKeys(m.get("username"));
    driver.findElement(By.id("pass")).sendKeys(m.get("password"));
	
}

@When("person submit the button")
public void person_submit_the_button() throws InterruptedException {
	WebElement login = driver.findElement(By.name("login"));
	login.click();
	Thread.sleep(2000); 
}

@Then("person go to unwanted page")
public void person_go_to_unwanted_page() {
	Assert.assertTrue(driver.getCurrentUrl().contains("?privacy_mutation_token"));
	System.out.println("navigated the invalid page");
	//driver.quit();  
}
}

*/

//---------------------------------------------------------------------------------------------
	/*

	//	Two data without header or Two data list not working open only one browser
	WebDriver driver;
	
@Given("human facebook login page")
public void human_facebook_login_page() {
	
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("https://www.facebook.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
}
@When("human given datas username and password")
public void human_given_datas_username_and_password(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	
	List<List<String>> aslist = dataTable.asLists(String.class);
	
    for(List<String> x:aslist)
	{
		driver.findElement(By.id("email")).sendKeys(x.get(0));
		driver.findElement(By.id("pass")).sendKeys(x.get(1));
		Thread.sleep(2000);
	}
}
	
//	for(int i=0;i<=aslist.size();i++) i can learn this
//	{
//	 driver.findElement(By.id("email")).sendKeys(aslist.get(0).get(0));	
//	driver.findElement(By.id("pass")).sendKeys(aslist.get(i).get(1));	
//}
  
@When("human submit the button")
public void human_submit_the_button() {
	
      driver.findElement(By.name("login")).click();
}
	
}
*/

//---------------------------------------------------------------------------------
	/*
// one data without header or one data list
	WebDriver driver;
	
@Given("user facebook login page")
public void user_facebook_login_page() {
	
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
}
@When("user given datas username and password")
public void user_given_datas_username_and_password(io.cucumber.datatable.DataTable dataTable) {
	
	List<String> data = dataTable.asList();
	
	driver.findElement(By.id("email")).sendKeys(data.get(0));
    driver.findElement(By.id("pass")).sendKeys(data.get(1));
}

@When("user submit the button")
public void user_submit_the_button() throws InterruptedException {
	driver.findElement(By.name("login")).click();
	Thread.sleep(2000);  
}

@Then("user go to unwanted page")
public void user_go_to_unwanted_page() {

	Assert.assertTrue(true);
	System.out.println("navigated the invalid page");
}
}
*/
	
//---------------------------------------------------------------------------------
	
	
	//dont import baseclass and login page
	//username and password multiple time, using examples given the feature files
	WebDriver driver;
@Given("user facebook login page")
public void user_facebook_login_page() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
}

@When("user given datas username and password")
public void user_given_datas_username_and_password() {
	driver.findElement(By.id("email")).sendKeys("8148427602");
	 driver.findElement(By.id("pass")).sendKeys("ivanamax23");
}
@When("user given datas username {string} and password {string}")
public void user_given_datas_username_and_password(String user, String pass) {
	driver.findElement(By.id("email")).sendKeys(user);
	 driver.findElement(By.id("pass")).sendKeys(pass);
	
}
@When("user submit the button")
public void user_submit_the_button() throws InterruptedException {
	driver.findElement(By.name("login")).click();
	Thread.sleep(2000);
}

@Then("user go to unwanted page")
public void user_go_to_unwanted_page() {
	Assert.assertTrue(driver.getCurrentUrl().contains("?privacy_mutation_token"));
	System.out.println("navigated the invalid page");
	driver.quit();
}}


//-------------------------------------------------------------------------------------------------
	/*
//dont import baseclass and login page
	//username and password not given the feature files
	
	WebDriver driver;
	
@Given("user inside facebook login page")
public void user_inside_facebook_login_page() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
}

@When("user two datas username and password and password")
public void user_two_datas_username_and_password_and_password() {
   driver.findElement(By.id("email")).sendKeys("vanajabobby");
   driver.findElement(By.id("pass")).sendKeys("ivanamax");
}

@When("user enter login button")
public void user_enter_login_button() throws InterruptedException {
    driver.findElement(By.name("login")).click();
	Thread.sleep(2000);
}

@Then("user navigate another page")
public void user_navigate_another_page() {
	Assert.assertTrue(driver.getCurrentUrl().contains("?privacy_mutation_token"));
	System.out.println("navigated the invalid page");
	driver.quit();
}
}
*/

//----------------------------------------------------------------------------------------
	/*
//dont import baseclass and login page
//username and password given the feature files
	
WebDriver driver;
@Given("user in facebook login page")
public void user_in_facebook_login_page() {
	
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
}

@When("user fill details username and password {string} and password {string}")
public void user_fill_details_username_and_password_and_password(String user, String pass) {
    
   driver.findElement(By.id("email")).sendKeys(user);
   driver.findElement(By.id("pass")).sendKeys(pass);
}

@When("user should be enter login button")
public void user_should_be_enter_login_button() throws InterruptedException {
	driver.findElement(By.name("login")).click();
	Thread.sleep(2000);	
}

@Then("user navigate login page")
public void user_navigate_login_page() {
	Assert.assertTrue(driver.getCurrentUrl().contains("?privacy_mutation_token"));
	System.out.println("navigated the invalid page");
	driver.quit();
} }
*/




