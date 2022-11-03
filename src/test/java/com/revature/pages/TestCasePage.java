package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCasePage {
    public TestCasePage(WebDriver driver){
        PageFactory.initElements(driver,this);


    }
    @FindBy(xpath = "/html/head/title")
    public WebElement title;

    @FindBy(xpath = "//*[@id=\"root\"]/form/fieldset/textarea[1]")
    public WebElement descriptionInput;

    @FindBy(xpath = "//*[@id=\"root\"]/form/fieldset/textarea[2]")
    public WebElement stepsInput;

    @FindBy(xpath = "//*[@id=\"root\"]/form/fieldset/button")
    public WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"root\"]/table/tbody/tr[last()]")
    public WebElement lastAddedTestCase;

    @FindBy(xpath = "//*[@id=\"root\"]/table/tbody/tr[last()]/td[1]")
    public WebElement lastAddedTestCaseID;
    @FindBy(xpath = "//*[@id=\"root\"]/table/tbody/tr[last()]/td[2]")
    public WebElement lastAddedTestCaseDescription;

    @FindBy(xpath = "//*[@id=\"root\"]/table/tbody/tr[last()]/td[3]")
    public WebElement lastAddedTestCaseResult;

    @FindBy(xpath = "//*[@id=\"root\"]/table/tbody/tr[last()]/td[4]/button")
    public WebElement lastAddedTestCaseDetailsButton;

    @FindBy(xpath = "/html/body/div[3]/div/div")
    public WebElement modal;

    @FindBy(xpath = "/html/body/div[3]/div/div/h3")
    public WebElement modalTestCaseId;

    @FindBy(xpath = "/html/body/div[3]/div/div/p[6]")
    public WebElement modalPerformedBy;

    @FindBy(xpath = "/html/body/div[3]/div/div/button[1]")
    public WebElement modalClose;

    @FindBy(xpath = "/html/body/div[3]/div/div/button[2]")
    public WebElement modalEdit;

}

