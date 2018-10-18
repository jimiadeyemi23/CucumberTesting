package com.qa.CucumberTesting;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Step 
{
	
	public WebDriver driver = null;
	
	static ExtentReports extent = new ExtentReports("C:\\Users\\Admin\\Desktop\\Reports\\CucumberReport.html", true);
	ExtentTest test;
	

	
	@Before
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Given("^the correct web address$")
	public void the_correct_web_address()
	{
	    // Write code here that turns the phrase above into concrete actions	
		test = extent.startTest("Browse items");
		test.log(LogStatus.INFO, "test started");
		
		driver.get("http://www.practiceselenium.com/welcome.html");
		
		if(driver.getCurrentUrl().equals("http://www.practiceselenium.com/welcome.html"))
		{
			test.log(LogStatus.PASS, "Welcome page accessed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Could not find Welcome page");
		}
		
		assertEquals("http://www.practiceselenium.com/welcome.html", driver.getCurrentUrl());
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page()
	{
	    // Write code here that turns the phrase above into concrete actions
		MenuPage menu = new MenuPage();
		
		menu = PageFactory.initElements(driver, MenuPage.class);
		menu.MenuClick();
		
		driver.navigate().to("http://www.practiceselenium.com/menu.html");
		
		test.log(LogStatus.INFO, "i_navigate_to_the_Menu_page");
		
		if(driver.getCurrentUrl().equals("http://www.practiceselenium.com/menu.html"))
		{
			test.log(LogStatus.PASS, "Menu page accessed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Could not find Menu page");
		}
		
		//assertEquals(true, driver.navigate().to("http://www.practiceselenium.com/menu.html"));

		assertEquals("http://www.practiceselenium.com/menu.html", driver.getCurrentUrl());
		
		

	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() 
	{
	    // Write code here that turns the phrase above into concrete actions
		MenuPage menu = new MenuPage();
		menu = PageFactory.initElements(driver, MenuPage.class);
		menu.CheckoutButton();
		
		
		test.log(LogStatus.INFO, "i_can_browse_a_list_of_the_available_products");
		
		if(menu.CheckoutButton() == true)
		{
			test.log(LogStatus.PASS, "There is a list of products thanks to the Checkout buttons");
		}
		else
		{
			test.log(LogStatus.FAIL, "There are no products");
		}
		
		
		
		driver.close();
	    
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button()
	{
	    // Write code here that turns the phrase above into concrete actions
		MenuPage menu = new MenuPage();
		menu = PageFactory.initElements(driver, MenuPage.class);
		
		menu.CheckoutMenuButton.click();
		//menu.CheckoutButton();

	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page()
	{
	    // Write code here that turns the phrase above into concrete actions
		MenuPage menu = new MenuPage();
		menu = PageFactory.initElements(driver, MenuPage.class);
		menu.clickCheckOutMenuButton();
		
		
		test.log(LogStatus.INFO, "i_am_taken_to_the_checkout_page");
		
		if(driver.getCurrentUrl().equals("http://www.practiceselenium.com/check-out.html"))
		{
			test.log(LogStatus.PASS, "Checkout page accessed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Could not find Checkout page");
		}
		
		assertEquals("http://www.practiceselenium.com/check-out.html", driver.getCurrentUrl());
		
		
		extent.flush();
		
		driver.close();
	}
	
}
