package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MatricesPage {
    public MatricesPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "/html/head/title")
    public WebElement title;

    @FindBy(xpath = "//*/button[contains(text(),'Show')]")
    public WebElement firstShowMatrix;

    @FindBy(xpath = "//*[contains(text(),'Edit')]")
    public WebElement firstEdit;

    @FindBy(xpath = "//*/div/ul[1]/li[1]/button")
    public WebElement testCaseRemoveButton;

    @FindBy(xpath = "//*/div/ul[2]/li[1]/button")
    public WebElement defectRemoveButton;

    @FindBy(xpath = "//*/div/ul[1]/li/button[contains(text(),'Add')]")
    public WebElement testCaseAddButton;

    @FindBy(xpath = "//*/div/ul[2]/li/button[contains(text(),'Add')]")
    public WebElement defectAddButton;


    @FindBy(xpath = "//*/div/button")
    public WebElement saveRequirement;
}
