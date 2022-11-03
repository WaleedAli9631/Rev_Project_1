package com.revature.stepimplementations.defects;

import com.revature.runners.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReportDefectNegativeSteps {
    @Given("The employee is on the Defect Reporter Page")
    public void theEmployeeIsOnTheDefectReporterPage() {
        Runner.wait.until(ExpectedConditions.titleContains("Home"));
        Runner.homePage.defectReportingLink.click();
        Runner.wait.until(ExpectedConditions.titleContains("Case"));
    }

    @When("The employee selects todays date")
    public void theEmployeeSelectsTodaysDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();
        Runner.defectReporterPage.dateInput.sendKeys(dtf.format(now));
    }

    @When("The employee types in {string} with")
    public void theEmployeeTypesInWith(String arg0, String docArg) {
        if (arg0.equals("Description")) {
            Runner.defectReporterPage.descriptionInput.sendKeys(docArg);
        } else {
            Runner.defectReporterPage.stepsToReproduceInput.sendKeys(docArg);
        }

    }

    @When("The employee selects high priority")
    public void theEmployeeSelectsHighPriority() {
        for (int i = 0; i < 3; i++) {
            Runner.defectReporterPage.prioritySlider.sendKeys(Keys.ARROW_RIGHT);
        }
    }

    @When("The employee selects low severity")
    public void theEmployeeSelectsLowSeverity() {
        for (int i = 0; i < 3; i++) {
            Runner.defectReporterPage.severitySlider.sendKeys(Keys.ARROW_LEFT);
        }
    }

    @When("The employee clicks the report button")
    public void theEmployeeClicksTheReportButton() {
        Runner.defectReporterPage.reportButton.click();
    }

    @Then("No confirmation dialog appears")
    public void noConfirmationDialogAppears() {
        boolean alertIsPresent = true;
        try {
            Runner.driver.switchTo().alert();
        } catch (NoAlertPresentException e) {
            alertIsPresent = false;
        }
        Assert.assertFalse(alertIsPresent);
    }
}
