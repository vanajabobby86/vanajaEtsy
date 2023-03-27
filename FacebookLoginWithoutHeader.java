package org.stepdefinitiion;

import java.util.List;

import org.baseclass.BaseClass;
import org.loginpage.FacebookLoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FacebookLoginWithoutHeader extends FacebookLoginPage {
	//FacebookLoginPage fb;
@Given("user go to the login functionality")
public void user_go_to_the_login_functionality() {
	launchbrowser("chrome");
	launchurl("https://www.facebook.com/");
	implicitlyWait(20);    
}

@When("user give the datas username and password")
public void user_give_the_datas_username_and_password(io.cucumber.datatable.DataTable datatable) {
	//new FacebookLoginPage();
	List<String> datas=datatable.asList(String.class);
	String username=datas.get(0);
	String password=datas.get(1);
	senkeys(getUsername(),username);
	senkeys(getPassword(),password);  
}

@When("user click the button")
public void user_click_the_button() {
	clickloginbutton();
   
}

@Then("navigate the invalid page")
public void navigate_the_invalid_page() {
	System.out.println("navigate invalid page");
	quit();
}



}
