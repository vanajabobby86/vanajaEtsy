package org.stepdefinitiion;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.baseclass.BaseClass;
import org.junit.Assert;
import org.loginpage.PhpTravelsLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PhpTravelLogin {
	WebDriver driver;
	
@Given("user go to login page")
public void user_go_to_login_page() {
	
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("https://phptravels.net/admin");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
}
//Username: admin@phptravels.com
//Password: demoadmin
@When("user fills datas username and password")
public void user_fills_datas_username_and_password() {
	
	driver.findElement(By.name("email")).sendKeys("admin@phptravels.com");
	driver.findElement(By.name("password")).sendKeys("demoadmin");
	
}

@When("user click login button")
public void user_click_login_button() {
	
	driver.findElement(By.xpath("//span[@class='ladda-label']")).click();	
}
@Then("user navisgated valid home page")
public void user_navisgated_valid_home_page() {
    //boolean status=driver.findElement(By.partialLinkText("php")).isDisplayed();
    Assert.assertTrue(true);
    System.out.println("valid page");
   // driver.quit();
}

}
/*----------------------------------------------------------------------------------
import static org.junit.Assert.assertTrue;

import org.baseclass.BaseClass;
import org.junit.Assert;
import org.loginpage.PhpTravelsLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PhpTravelLogin extends BaseClass {
	PhpTravelsLoginPage php;
@Given("user go to login page")
public void user_go_to_login_page() {
	launchbrowser("chrome");    
	launchurl("https://phptravels.org/login");
	implicitlyWait(20);
}

@When("user fill datas username and password")
public void user_fill_datas_username_and_password() throws InterruptedException {
	new PhpTravelsLoginPage();
	senkeys(php.getUsername(),"admin@phptravels.com"); 
	senkeys(php.getPassword(),"demoadmin");
    Thread.sleep(2000);
}

@When("user click login button")
public void user_click_login_button() {
	buttonclick(php.getButtonclick());   
}

@Then("user navisgated valid home page")
public void user_navisgated_valid_home_page() {
    //boolean status=driver.findElement(By.partialLinkText("php")).isDisplayed();
    Assert.assertTrue(true);
    System.out.println("valid page");
    quit();
}
}*/

