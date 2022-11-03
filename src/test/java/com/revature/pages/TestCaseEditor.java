package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCaseEditor {
    public TestCaseEditor(WebDriver driver){
        PageFactory.initElements(driver,this);


    }@FindBy(xpath = "//*/h1")
    public WebElement editorCaseId;

    @FindBy(xpath = "//*/fieldset[1]/textarea[1]")
    public WebElement editorDescriptionTextArea;

    @FindBy(xpath = "//*/fieldset[1]/textarea[2]")
    public WebElement editorStepsTextArea;

    @FindBy(xpath = "//*/button")
    public WebElement editorEditButton;

    @FindBy(xpath = "//*/fieldset[1]/input")
    public WebElement editorCheckboxButton;

    @FindBy(xpath = "//*/fieldset[1]/select")
    public WebElement editorSelectPerformedBy;

    @FindBy(xpath = "//*/fieldset[2]/select")
    public WebElement editorTestResult;

    @FindBy(xpath = "//*/fieldset[1]/p[2]")
    public WebElement editorPerformedByNonEdit;

    @FindBy(xpath = "//*/fieldset[1]/p[1]")
    public WebElement editorCheckboxButtonNonEdit;

    @FindBy(xpath = "//*/fieldset[2]/textarea")
    public WebElement editorSummaryNonEdit;

    @FindBy(xpath = "//*/fieldset[2]/textarea")
    public WebElement editorSummary;

    @FindBy(xpath = "//*/button[2]")
    public WebElement editorSave;

    @FindBy(xpath = "//*/button[1]")
    public WebElement editorReset;
}
