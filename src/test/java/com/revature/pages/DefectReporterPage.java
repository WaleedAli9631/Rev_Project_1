package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DefectReporterPage {
    public DefectReporterPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*/input[1]")
    public WebElement dateInput;

    @FindBy(xpath = "//*/textarea[1]")
    public WebElement descriptionInput;

    @FindBy(xpath = "//*/textarea[2]")
    public WebElement stepsToReproduceInput;

    @FindBy(xpath = "//*/input[2]")
    public WebElement severitySlider;

    @FindBy(xpath = "//*/input[3]")
    public WebElement prioritySlider;

    @FindBy(xpath = "//*/button")
    public WebElement reportButton;

    @FindBy(xpath = "/html/body/div[3]/div/div")
    public WebElement modalPopUp;

    @FindBy(xpath = "/html/body/div[3]/div/div/h4")
    public WebElement modalDefectID;

    @FindBy(xpath = "/html/body/div[3]/div/div/button")
    public WebElement closeModal;
}
