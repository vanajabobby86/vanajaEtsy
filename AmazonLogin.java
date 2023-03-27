package org.stepdefinitiion;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import gherkin.deps.com.google.gson.internal.bind.JsonTreeReader;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonLogin {

	WebDriver driver;

	@When("user giver username and password of amazon login page")
	public void user_giver_username_and_password_of_amazon_login_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@When("user click amazon signin button")
	public void user_click_amazon_signin_button() throws InterruptedException {

	}

	@When("user add first product from amazon")
	public void user_add_first_product_from_amazon() throws InterruptedException {
		WebElement firstproduct = driver.findElement(By.id("twotabsearchtextbox"));
		firstproduct.sendKeys("Shoes");
		driver.findElement(By.id("nav-search-submit-button")).click();
		WebElement shoes1 = driver.findElement(By.xpath(
				"//*[@id=\'search\']/div[1]/div[1]/div/span[1]/div[1]/div[7]/div/div/div/div/div[2]/div/span/a/div/img"));
		shoes1.click();
		Set<String> handles = driver.getWindowHandles();
		List<String> list = new ArrayList();
		list.addAll(handles);
		driver.switchTo().window(list.get(1));
		WebElement selectsize = driver.findElement(By.xpath("//select[@name='dropdown_selected_size_name']"));
		Select s = new Select(selectsize);
		s.selectByIndex(2);
		Thread.sleep(2000);
		WebElement addtocart = driver.findElement(By.xpath("//span[@id='submit.add-to-cart']"));
		addtocart.click();

	}

	@When("user add second product from amazon")
	public void user_add_second_product_from_amazon() throws InterruptedException {
		WebElement secondproduct = driver.findElement(By.id("twotabsearchtextbox"));
		secondproduct.sendKeys("Goldwinner");
		driver.findElement(By.id("nav-search-submit-button")).click();

		WebElement sunflower = driver.findElement(By.xpath("//img[@alt='Gold Winner Refined Sunflower Oil, 1L']"));
		sunflower.click();
		Set<String> handles = driver.getWindowHandles();
		List<String> list = new ArrayList();
		list.addAll(handles);
		driver.switchTo().window(list.get(2));

		WebElement addtocart = driver.findElement(By.id("add-to-cart-button"));
		addtocart.click();

	}

	@When("user add third product from amazon")
	public void user_add_third_product_from_amazon() throws InterruptedException {
		WebElement third = driver.findElement(By.id("twotabsearchtextbox"));
		third.sendKeys("womendress");
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement yellowfrock = driver
				.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-tall-aspect'])[10]"));
		js.executeScript("arguments[0].click()", yellowfrock);
		Thread.sleep(2000);

		Set<String> handles = driver.getWindowHandles();
		List<String> list = new ArrayList();
		list.addAll(handles);
		driver.switchTo().window(list.get(3));

		WebElement size = driver.findElement(By.id("native_dropdown_selected_size_name"));
		Select s = new Select(size);
		s.selectByIndex(3);
		Thread.sleep(2000);
		WebElement addtocart = driver.findElement(By.xpath("//input[@name='submit.add-to-cart']"));
		addtocart.click();
	}

	@When("user add fourth product from amazon")
	public void user_add_fourth_product_from_amazon() throws InterruptedException {
		WebElement fourth = driver.findElement(By.id("twotabsearchtextbox"));
		fourth.sendKeys("Toys");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		WebElement auto = driver.findElement(By.linkText("Centy Toys Plastic Pull Back Auto Rickshaw, Number Of Pieces: 1, Multicolour"));
		auto.click();
		Set<String> handles = driver.getWindowHandles();
		List<String> list = new ArrayList();
		list.addAll(handles);
		driver.switchTo().window(list.get(4));
		
		WebElement addtocart = driver.findElement(By.id("add-to-cart-button"));
		addtocart.click();
		
	}

	@When("user add fifth product from amazon")
	public void user_add_fifth_product_from_amazon() throws InterruptedException {
		WebElement fifth = driver.findElement(By.id("twotabsearchtextbox"));
		fifth.sendKeys("ball");
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement checkball = driver.findElement(By.xpath(
				"//*[@id=\'search\']/div[1]/div[1]/div/span[1]/div[1]/div[23]/div/div/div/div/div[1]/span/a/div/img"));
		js.executeScript("arguments[0].click()", checkball);

		Set<String> handles = driver.getWindowHandles();
		List<String> list = new ArrayList();
		list.addAll(handles);
		driver.switchTo().window(list.get(5));

		driver.findElement(By.id("submit.add-to-cart")).click();
	}

	@When("user verify products add or not inside amazon")
	public void user_verify_products_add_or_not_inside_amazon() {

	}

	@When("product price list out from selecting product")
	public void product_price_list_out_from_selecting_product() {

	}

	@When("user remove one product from the list")
	public void user_remove_one_product_from_the_list() {

	}

	@When("user calculate selected item and sum of two product")
	public void user_calculate_selected_item_and_sum_of_two_product() {

	}
}
