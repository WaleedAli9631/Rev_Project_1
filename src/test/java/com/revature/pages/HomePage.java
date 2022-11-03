package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"root\"]/nav/p")
    public WebElement welcomeMessage;

    @FindBy(xpath = "/html/head/title")
    public WebElement title;

    @FindBy(partialLinkText = "Matrices")
    public WebElement matricesLink;

    @FindBy(partialLinkText = "Test Cases")
    public WebElement testCasesLink;

    @FindBy(partialLinkText = "Report a Defect")
    public WebElement defectReportingLink;

    @FindBy(partialLinkText = "Defect Overview")
    public WebElement defectOverviewLink;

    @FindBy(xpath = "//button[contains(text(),'Create A new Requirements Matrix')]")
    public WebElement createNewRTM;

    @FindBy(xpath = "//*[@id=\"root\"]/input")
    public WebElement matrixTitle;

    @FindBy(xpath = "//*[@id=\"root\"]/fieldset/button")
    public WebElement addRequirement;

    @FindBy(xpath = "//*[@id=\"root\"]/button")
    public WebElement saveMatrix;

    @FindBy(xpath = "//*[@id=\"root\"]/nav/a[5]")
    public WebElement logoutButton;

    @FindBy(xpath = "//body/div[@id='root']/table[1]")
    public WebElement defectTable;

    @FindBy(xpath = "//*[@id=\"root\"]/table/tbody/tr/td[3]/button")
    public WebElement firstSelect;

    @FindBy(xpath = "//h4")
    public WebElement selectedDescription;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/input[1]")
    public WebElement assignPerson;

    @FindBy(xpath = "//button[contains(text(),'Assign')]")
    public WebElement assignPersonButton;

    @FindBy(xpath = "//tbody/tr/td[1]")
    public WebElement defectIDOne;

    @FindBy(xpath = "//body/div[@id='root']/ul[1]/li[last()]/div[1]/span[1]/p[1]/b[1]")
    public WebElement testerCheckID;

    @FindBy(xpath = "//*/p/b[1]")
    public WebElement firstDefect;

    @FindBy(xpath = "//*/button[contains(text(),\"Change Status\")]")
    public WebElement firstChangeStatus;

    @FindBy(xpath = "//*/div/button[1]")
    public WebElement acceptedButton;

    @FindBy(xpath = "//*/p/b[2]")
    public WebElement firstStatus;

}
