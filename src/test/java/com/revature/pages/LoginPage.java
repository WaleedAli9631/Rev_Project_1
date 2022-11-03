package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(name = "username")
    public WebElement usernameInput;
    @FindBy(name = "pass")
    public WebElement passwordInput;
    @FindBy(xpath = "//*[@id=\"root\"]/fieldset/button")
    public WebElement loginButton;
}
