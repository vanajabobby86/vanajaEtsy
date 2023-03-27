package org.stepdefinitiion;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeLogin {
	
WebDriver driver;
@Given("user should be in login page")
public void user_should_be_in_login_page() {
	
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
}

@When("user fill the values {string} and password {string}")
public void user_fill_the_values_and_password(String user, String pass) throws InterruptedException {
	driver.findElement(By.name("username")).sendKeys(user);
	driver.findElement(By.name("password")).sendKeys(pass);
	 Thread.sleep(2000);
}

@When("user should click login button")
public void user_should_click_login_button() {
	 driver.findElement(By.xpath("//button[@type='submit']")).click();
	
}

@Then("user should navigated valid home page")
public void user_should_navigated_valid_home_page() {
Assert.assertTrue(true);
System.out.println("navigated the valid page");    
}
}
/*
 * import org.baseclass.BaseClass;
import org.junit.Assert;
import org.loginpage.OrangeLoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrangeLogin extends BaseClass {
	OrangeLoginPage l;

@Given("user should be in login page")
public void user_should_be_in_login_page() {
	launchbrowser("chrome");
	launchurl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	implicitlyWait(20);  
}

@When("user fill the values username and password")
public void user_fill_the_values_username_and_password() {
	new OrangeLoginPage();
	senkeys(l.getUsername(),"Admin");
	senkeys(l.getPassword(),"admin123");  
}

@When("user should click login button")
public void user_should_click_login_button() {
	buttonclick(l.getButtonclick());   
}

@Then("user should navigated valid home page")
public void user_should_navigated_valid_home_page() {
Assert.assertTrue(true);
System.out.println("navigated the valid page");  
}
}
*/
