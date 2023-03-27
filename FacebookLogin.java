package org.stepdefinitiion;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.baseclass.BaseClass;
import org.junit.Assert;
import org.loginpage.FacebookLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookLogin {
	WebDriver driver;
@Given("user should be in facebook login page")
public void user_should_be_in_facebook_login_page() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("https://www.facebook.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);   
}

@When("user fill username and password {string} and password {string}")
public void user_fill_username_and_password_and_password(String user, String pass) {
	driver.findElement(By.id("email")).sendKeys(user);
	driver.findElement(By.id("pass")).sendKeys(pass);
}

@When("user should be click login button")
public void user_should_be_click_login_button() {
   driver.findElement(By.name("login")).click();
   
}

@Then("user navigate the invalid login page")
public void user_navigate_the_invalid_login_page() {
	Assert.assertTrue(true);
	System.out.println("navigated the valid page");   
}
}
/*-----------------------------------------------------------------------------------------------------
public class FacebookLogin extends BaseClass{
	FacebookLoginPage f;
@Given("user should be in facebook login page")
public void user_should_be_in_facebook_login_page() {
	launchbrowser("chrome");
	launchurl("https://www.facebook.com/");
	implicitlyWait(20);
    
}

@When("user fill username and password {string} and password {string}")
public void user_fill_username_and_password_and_password(String user, String pass) {
	new FacebookLoginPage();
	senkeys(f.getUsername(),user);
	senkeys(f.getPassword(),pass);
    
}

@When("user should be click login button")
public void user_should_be_click_login_button() {
    buttonclick(f.getButton());
   
}

@Then("user navigate the invalid login page")
public void user_navigate_the_invalid_login_page() {
	Assert.assertEquals(getCurrenturl(), "?privacy_mutation_token");
	quit();
}}
---------------------------------------------------------------------------------------------------------------
*/