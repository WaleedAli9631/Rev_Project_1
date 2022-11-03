package com.revature.stepimplementations.defects;

import com.revature.runners.Runner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class ReportDefectPositiveSteps {
    @When("The employee clicks Ok")
    public void theEmployeeClicksOk() {
        Runner.driver.switchTo().alert().accept();
    }

    @Then("There should be a confirmation box")
    public void thereShouldBeAConfirmationBox() {
        Runner.wait.until(ExpectedConditions.alertIsPresent());
    }

    @Then("A modal should appear with a Defect ID")
    public void aModalShouldAppearWithADefectID() {
        Runner.wait.until(ExpectedConditions.visibilityOf(Runner.defectReporterPage.modalPopUp));

        Assert.assertTrue(Runner.defectReporterPage.modalPopUp.isDisplayed());

        Assert.assertTrue(Runner.defectReporterPage.modalDefectID.getText().contains("Defect"));
    }

    @When("The employee clicks close")
    public void theEmployeeClicksClose() {
        Runner.defectReporterPage.closeModal.click();
    }

    @Then("The modal should disappear")
    public void theModalShouldDisappear() {
        List<WebElement> webElementList = Runner.driver.findElements(By.xpath("/html/body/div[3]/div/div"));
        Assert.assertFalse(webElementList.size()>1);
    }
}
