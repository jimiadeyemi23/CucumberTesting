package com.qa.CucumberTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class MenuPage 
{
	
	@FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a")
	WebElement MenuButton;
	
	@FindBy(xpath = "//*[@id=\"wsb-button-00000000-0000-0000-0000-000451955160\"]/span")
	WebElement Checkout1;
	
	@FindBy(xpath = "//*[@id=\"wsb-button-00000000-0000-0000-0000-000451959280\"]/span")
	WebElement CheckOut2;
	
	
	@FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[5]/a")
	WebElement CheckoutMenuButton;
	
	
	public void MenuClick()
	{
		MenuButton.click();
	}
	
	public boolean CheckoutButton()
	{
		if(Checkout1.isDisplayed() && CheckOut2.isDisplayed())
		{
			return true;
		}
		return false;
		
	}
	
	public void clickCheckOutMenuButton()
	{

		CheckoutMenuButton.click();
	}
}
