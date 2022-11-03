package com.revature.stepimplementations.testcases;

import com.revature.runners.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class TestCasesSteps {
    String description;
    String testCaseId;
    String descriptionEditorText;
    String stepText;
    String automated;
    String performedBy;
    String testResult;
    String summary;

    @Given("The tester is on the test case dashboard")
    public void theTesterIsOnTheTestCaseDashboard() {
        Runner.homePage.testCasesLink.click();
        try {
            Runner.wait.until(ExpectedConditions.titleContains("Test"));
        } catch (Exception e) {

        }
    }

    @When("The tester types {string} into input with")
    public void theTesterTypesIntoInputWith(String arg0, String docString) throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(1));

        if (arg0.equals("Description")) {
            description = docString;
            Runner.testCasePage.descriptionInput.sendKeys(docString);
        } else if (arg0.equals("Steps")) {
            Runner.testCasePage.stepsInput.sendKeys(docString);
        } else {
            throw new io.cucumber.java.PendingException();
        }
        Thread.sleep(Duration.ofSeconds(1));

    }

    @When("The tester presses the submit button")
    public void theTesterPressesTheSubmitButton() throws InterruptedException {
        Runner.testCasePage.submitButton.click();
        Thread.sleep(Duration.ofSeconds(1));
        testCaseId = Runner.testCasePage.lastAddedTestCaseID.getText();

    }

    @Then("The test case should appear at the bottom of the table")
    public void theTestCaseShouldAppearAtTheBottomOfTheTable() {
        Assert.assertEquals(Runner.testCasePage.lastAddedTestCaseDescription.getText(), description);
    }

    @Then("The test case result should say {string}")
    public void theTestCaseResultShouldSayUNEXECUTED(String arg1) {
        Assert.assertEquals(Runner.testCasePage.lastAddedTestCaseResult.getText(), arg1);
    }

    @When("The tester presses on details")
    public void theTesterPressesOnDetails() throws InterruptedException {
        testCaseId = Runner.testCasePage.lastAddedTestCaseID.getText();
        Runner.testCasePage.lastAddedTestCaseDetailsButton.click();
        Thread.sleep(Duration.ofSeconds(1));

    }

    @Then("A test case modal should appear showing the case ID")
    public void aTestCaseModalShouldAppearShowingTheCaseID() throws InterruptedException {
        Assert.assertTrue(Runner.testCasePage.modal.isDisplayed());
        Thread.sleep(Duration.ofSeconds(1));

        String[] idCheck = Runner.testCasePage.modalTestCaseId.getText().split("\\s+");

        Assert.assertEquals(idCheck[1], testCaseId);
    }

    @Then("The performed by field should say {string}")
    public void thePerformedByFieldShouldSayNoOne(String arg1) {
        Assert.assertEquals(Runner.testCasePage.modalPerformedBy.getText(), arg1);
    }

    @When("The tester presses the close buttton")
    public void theTesterPressesTheCloseButtton() {
        Runner.testCasePage.modalClose.click();
    }

    @Then("The Modal Should be closed")
    public void theModalShouldBeClosed() {
        boolean isShown = Runner.driver.findElements(By.xpath("/html/body/div[3]/div/div")).size() == 0;

        Assert.assertTrue(isShown);

    }

    @When("The Tester clicks on edit within the modal")
    public void theTesterClicksOnEditWithinTheModal() throws InterruptedException {
        Runner.testCasePage.modalEdit.click();
        Thread.sleep(Duration.ofSeconds(1));

    }

    @Then("The Tester should be on the case editor for that case")
    public void theTesterShouldBeOnTheCaseEditorForThatCase() {
        String[] idCheck = Runner.testCaseEditor.editorCaseId.getText().split("\\s+");
        Assert.assertEquals(testCaseId, idCheck[2]);
    }

    @Then("The fields should be uneditable")
    public void theFieldsShouldBeUneditable() {
        Assert.assertFalse(Runner.testCaseEditor.editorDescriptionTextArea.isEnabled());
        Assert.assertFalse(Runner.testCaseEditor.editorStepsTextArea.isEnabled());
    }

    @When("The tester clicks on the edit button")
    public void theTesterClicksOnTheEditButton() {
        descriptionEditorText = Runner.testCaseEditor.editorDescriptionTextArea.getText();
        stepText = Runner.testCaseEditor.editorStepsTextArea.getText();
        automated = Runner.testCaseEditor.editorCheckboxButtonNonEdit.getText();
        performedBy = Runner.testCaseEditor.editorPerformedByNonEdit.getText();
        testResult = Runner.testCaseEditor.editorSummaryNonEdit.getText();
        summary = Runner.testCaseEditor.editorSummary.getText();

        Runner.testCaseEditor.editorEditButton.click();
    }

    @Then("The test case fields should be editable")
    public void theTestCaseFieldsShouldBeEditable() {
        Assert.assertTrue(Runner.testCaseEditor.editorDescriptionTextArea.isEnabled());
        Assert.assertTrue(Runner.testCaseEditor.editorStepsTextArea.isEnabled());
    }

    @When("The tester types in a new description into the description text area")
    public void theTesterTypesInANewDescriptionIntoTheDescriptionTextArea() {
        Runner.testCaseEditor.editorDescriptionTextArea.sendKeys("a new description");
    }

    @When("The tester types in a new steps into the steps text area")
    public void theTesterTypesInANewStepsIntoTheStepsTextArea() {
        Runner.testCaseEditor.editorStepsTextArea.sendKeys("a new steps");
    }

    @When("The tester clicks on the automated check mark")
    public void theTesterClicksOnTheAutomatedCheckMark() {
        Runner.testCaseEditor.editorCheckboxButton.click();
    }

    @When("The tester selects ryeGuy for performed from drop down")
    public void theTesterSelectsRyeGuyForPerformedFromDropDown() {
        Select dropDown = new Select(Runner.testCaseEditor.editorSelectPerformedBy);
        dropDown.selectByVisibleText("ryeGuy");
    }

    @When("The tester selects FAIL for test result from drop down")
    public void theTesterSelectsFAILForTestResultFromDropDown() {
        Select dropDown = new Select(Runner.testCaseEditor.editorTestResult);
        dropDown.selectByVisibleText("FAIL");
    }

    @When("The tester types in a new summary into the summary text area")
    public void theTesterTypesInANewSummaryIntoTheSummaryTextArea() {
        Runner.testCaseEditor.editorSummary.sendKeys("a new summary");
    }

    @When("The tester clicks save on test case page")
    public void theTesterClicksSaveOnTestCasePage() {
        Runner.testCaseEditor.editorSave.click();
    }

    @Then("A confirmation prompt should appear")
    public void aConfirmationPromptShouldAppear() {
        Runner.wait.until(ExpectedConditions.alertIsPresent());
    }

    @When("The tester clicks on Ok")
    public void theTesterClicksOnOk() {
        Runner.driver.switchTo().alert().accept();
    }

    @Then("An alert says the test case has been saved")
    public void anAlertSaysTheTestCaseHasBeenSaved() {
        Runner.wait.until(ExpectedConditions.alertIsPresent());
        String alertText = Runner.driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, "Test Case has been Saved");
        Runner.driver.switchTo().alert().dismiss();
    }

    @When("pause")
    public void pause() throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(1));
    }

    @When("The tester clicks on the reset button")
    public void theTesterClicksOnTheResetButton() throws InterruptedException {
        Runner.testCaseEditor.editorReset.click();
        Thread.sleep(Duration.ofSeconds(1));
    }

    @Then("The fields should be populated to their old values")
    public void theFieldsShouldBePopulatedToTheirOldValues() throws InterruptedException {
        Assert.assertEquals(descriptionEditorText, Runner.testCaseEditor.editorDescriptionTextArea.getText());
        Assert.assertEquals(stepText, Runner.testCaseEditor.editorStepsTextArea.getText());
        Assert.assertEquals(automated, Runner.testCaseEditor.editorCheckboxButtonNonEdit.getText());
        Assert.assertEquals(performedBy, Runner.testCaseEditor.editorPerformedByNonEdit.getText());
        Assert.assertEquals(testResult, Runner.testCaseEditor.editorSummaryNonEdit.getText());
        Assert.assertEquals(summary, Runner.testCaseEditor.editorSummaryNonEdit.getText());

    }
}
