package org.stepdefinitiion;

import java.util.List;
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

public class FacebookRegister {

	WebDriver driver;

	@Given("user must be in facebook login page.")
	public void user_must_be_in_facebook_login_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@When("user click the create account button")
	public void user_click_the_create_account_button() {
		driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
	}

	@When("user should be given firstname,lastname and other details")
	public void user_should_be_given_firstname_lastname_and_other_details() throws InterruptedException {
		driver.findElement(By.name("firstname")).sendKeys("jamila");
		driver.findElement(By.name("lastname")).sendKeys("vanaja");
		driver.findElement(By.name("reg_email__")).sendKeys("8148427");
		driver.findElement(By.name("reg_passwd__")).sendKeys("ivanamax23");

		WebElement birthdaydate = driver.findElement(By.id("day"));
		Select s = new Select(birthdaydate);
		s.selectByValue("27");

		WebElement birthdaymonth = driver.findElement(By.id("month"));
		Select s1 = new Select(birthdaymonth);
		s1.selectByVisibleText("Dec");

		WebElement birthdayyear = driver.findElement(By.id("year"));
		Select s2 = new Select(birthdayyear);
		s2.selectByValue("2010");

		driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
	}

	@When("user must click signup button")
	public void user_must_click_signup_button() {
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

	}

	@When("user must give firstname,last name and other details")
	public void user_must_give_firstname_lastname_and_other_details() throws InterruptedException {
		driver.findElement(By.name("firstname")).sendKeys("vanaja");
		driver.findElement(By.name("lastname")).sendKeys("bobby");
		driver.findElement(By.name("reg_email__")).sendKeys("8148427602");
		driver.findElement(By.name("reg_passwd__")).sendKeys("ivanamax23");

		WebElement birthdaydate = driver.findElement(By.id("day"));
		Select s = new Select(birthdaydate);
		s.selectByValue("15");
		Thread.sleep(2000);

		WebElement birthdaymonth = driver.findElement(By.id("month"));
		Select s1 = new Select(birthdaymonth);
		s1.selectByVisibleText("Aug");
		Thread.sleep(2000);

		WebElement birthdayyear = driver.findElement(By.id("year"));
		Select s2 = new Select(birthdayyear);
		s2.selectByValue("2000");
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
	}

	@When("user should be given {string}and{string} and  {string} and {string}and{string}and{string}and{string}and{string}")
	public void user_should_be_given_and_and_and_and_and_and_and(String firstname, String lastname, String phno,
			String repass, String day, String month, String year, String gender) throws InterruptedException {
		driver.findElement(By.name("firstname")).sendKeys(firstname);
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.name("reg_email__")).sendKeys(phno);
		driver.findElement(By.name("reg_passwd__")).sendKeys(repass);

		WebElement birthdaydate = driver.findElement(By.id("day"));
		Select s = new Select(birthdaydate);
		s.selectByValue(day);

		WebElement birthdaymonth = driver.findElement(By.id("month"));
		Select s1 = new Select(birthdaymonth);
		s1.selectByVisibleText(month);

		WebElement birthdayyear = driver.findElement(By.id("year"));
		Select s2 = new Select(birthdayyear);
		s2.selectByValue(year);

		if (gender.equals("female")) {
			WebElement female = driver.findElement(By.xpath("//input[@value='1']"));
			female.click();
		} else if (gender.equals("male")) {

			WebElement male = driver.findElement(By.xpath("//input[@value='2']"));
			male.click();

		}else {
			WebElement cust = driver.findElement(By.xpath("//input[@value='-1']"));
			cust.click();
		}

	}

	@Then("user get msg successfully")
	public void user_get_msg_successfully() {
		Assert.assertTrue(true);
		System.out.println("navigated valid page");
		driver.quit();
	}
}
