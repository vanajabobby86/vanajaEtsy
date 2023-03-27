package org.stepdefinitiion;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EcommerceEtsy {

	WebDriver driver;

	@Given("user be in login page")
	public void user_be_in_login_page() {
		WebDriverManager.edgedriver().setup();
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--incognito");
		driver = new EdgeDriver();
		driver.get("https://www.etsy.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

	}

	@When("user giver username and password of etsy login page")
	public void user_giver_username_and_password_of_etsy_login_page() {

		driver.findElement(By.xpath(
				"//button[@class='wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin']"))
				.click();
		driver.findElement(By.name("email")).sendKeys("seraraja555@gmail.com");
		driver.findElement(By.name("password")).sendKeys("9842856041"); // after sign in find below elements
	}

	@When("user click signin button")
	public void user_click_signin_button() throws InterruptedException {
		
		driver.findElement(By.xpath("//button[@value='sign-in']")).click();
		Thread.sleep(3000);

	}

	@When("user add first product")
	public void user_add_first_product() throws InterruptedException {
		WebElement weding = driver.findElement(By.id("catnav-primary-link-10983"));
		weding.click();
		WebElement inv = driver.findElement(By.xpath(
				"(//p[@class='ingress-title wt-text-truncate--multi-line wt-text-caption-title child-hover-underline'])[8]"));
		inv.click();
		WebElement wed = driver.findElement(By.xpath("//h3[contains(text(),'Party Favor')]"));
		wed.click();
		Set<String> hy = driver.getWindowHandles();
		List<String> li = new ArrayList<String>();
		li.addAll(hy);
		driver.switchTo().window(li.get(1));
//		driver.findElement(By.xpath("//*[@id='listing-page-cart']/div[6]/div[1]/div[3]/div[2]/form/div/button"))
//				.click();
//		driver.findElement(By.xpath("//*[@id='atc-overlay-content']/div[2]/div/a")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//div[@class='wt-hide-xs wt-show-md']")).click();

	}

	@When("user add second product")
	public void user_add_second_product() throws InterruptedException {
		WebElement Toys = driver.findElement(By.xpath("//span[@id='catnav-primary-link-11049']"));
		Toys.click();
		WebElement remotecar = driver.findElement(By.xpath("(//a[@class='parent-hover-underline'])[2]"));
		remotecar.click();
		WebElement emproidery = driver.findElement(By.xpath("//img[@alt='Embroidery']"));
		emproidery.click();
		WebElement pinkcar = driver.findElement(By.partialLinkText("Set of 2 Car Coaster,Pink Car Accessories"));
		pinkcar.click();
		Set<String> handles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>();
		list.addAll(handles);
		driver.switchTo().window(list.get(2));
		WebElement makselect = driver.findElement(By.id("variation-selector-0"));
		Select s = new Select(makselect);
		s.selectByValue("2781510667");
		Thread.sleep(2000);
		WebElement happyselect = driver.findElement(By.xpath("(//select[@class='wt-select__element '])[2]"));
		Select s1 = new Select(happyselect);
		s1.selectByIndex(1);
		Thread.sleep(2000);
		WebElement quantity = driver.findElement(By.id("listing-page-quantity-select"));
		Select s2 = new Select(quantity);
		s2.selectByIndex(0);
		Thread.sleep(2000);
		WebElement addtocart1 = driver.findElement(By.xpath("//button[contains(text(),'Add to basket')]"));
		addtocart1.click();
		Thread.sleep(2000);
		WebElement keepshoping = driver.findElement(By.xpath("//div[@class='wt-hide-xs wt-show-md']"));
		keepshoping.click();
	}

	@When("user add third product")
	public void user_add_third_product() throws InterruptedException {
		WebElement homeproduct = driver.findElement(By.id("catnav-primary-link-891"));
		homeproduct.click();
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement light = driver
				.findElement(By.xpath("//*[@id=\'content\']/div/div[1]/div/div[2]/div[2]/div/div/div[2]/a/div[1]/img"));
		js.executeScript("arguments[0].click()", light);
		Thread.sleep(2000);

		WebElement light1 = driver.findElement(By.partialLinkText("12 Balls LED Diwali Window Curtain String Lights"));
		js.executeScript("arguments[0].click()", light1);
		Thread.sleep(2000);

		Set<String> handles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>();
		list.addAll(handles);
		driver.switchTo().window(list.get(3));

		WebElement texts = driver.findElement(By.xpath("//textarea[@id = 'listing-page-personalization-textarea']"));
		Actions a = new Actions(driver);
		a.click();
		texts.sendKeys("i like to buy");

		WebElement option = driver.findElement(By.id("listing-page-quantity-select"));
		Select s = new Select(option);
		s.selectByIndex(1);
		Thread.sleep(2000);

		WebElement addcart = driver.findElement(By.xpath("(//button[@type='submit'])[3]"));
		js.executeScript("arguments[0].click()", addcart);
		Thread.sleep(2000);

	}

	@When("Proceed to check out")
	public void proceed_to_check_out() throws InterruptedException {
		WebElement checkout = driver.findElement(By.xpath("(//span[@class='submit-button-text'])[3]"));
		checkout.click();

		WebElement country = driver.findElement(By.id("country_id2-select"));
		Select s = new Select(country);
		s.selectByVisibleText("India");

		WebElement fullname = driver.findElement(By.id("name3-input"));
		fullname.sendKeys("vanaja bobby");
		Thread.sleep(2000);

		WebElement streetaddress = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		streetaddress.sendKeys("kalimarc");

		WebElement flat = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
		flat.sendKeys("17");

		WebElement city = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
		city.sendKeys("colachel");

		WebElement pincode = driver.findElement(By.xpath("(//input[@type='text'])[5]"));
		pincode.sendKeys("629251");

		WebElement state = driver.findElement(By.id("state8-select"));
		Select s1 = new Select(state);
		s1.selectByVisibleText("Tamil Nadu");

		WebElement phonenumber = driver.findElement(By.id("phone9-input"));
		phonenumber.sendKeys("9597766142");

		WebElement continuepayment = driver.findElement(By.xpath("//span[text()='Proceed to checkout']"));
		continuepayment.click();
		Thread.sleep(5000);
	
	
	}

	@When("verify product available or not")
	public void verify_product_available_or_not() throws InterruptedException, AWTException

	{
		WebElement etsylogo = driver.findElement(By.xpath("//button[@id='etsy-logo-branded-exit-button']"));
		etsylogo.click();
		WebElement returntocart = driver.findElement(By.xpath("(//button[@class='wt-btn wt-btn--transparent'])[4]"));
		returntocart.click();

		List<WebElement> verifylist = driver.findElements(
				By.xpath("//a[@class='wt-text-link-no-underline wt-text-body-01 wt-line-height-tight wt-break-word']"));
		for (WebElement x : verifylist) {
			System.out.println(x.getText());
		}
	}

	@When("product price list out")
	public void product_price_list_out() {
		List<WebElement> pricelist = driver
				.findElements(By.xpath("//p[@class = 'wt-text-title-01']//span[@class = 'money']"));
		for (WebElement x : pricelist) {
			// print 6 money price list
			System.out.println(x);
		}
		// 2,4,6 price list find out

	}

	@When("user remove one product")
	public void user_remove_one_product() {
		// particular element remove means
		List<WebElement> verifylist = driver.findElements(
				By.xpath("//a[@class='wt-text-link-no-underline wt-text-body-01 wt-line-height-tight wt-break-word']"));
		verifylist.remove(1);

		// remove all elements means code
	}

	@When("user calculate sum of two product")
	public void user_calculate_sum_of_two_product() {

	}
}