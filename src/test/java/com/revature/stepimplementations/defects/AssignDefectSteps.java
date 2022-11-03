package com.revature.stepimplementations.defects;

import com.revature.runners.Runner;
import com.revature.stepimplementations.login.LoginSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.input.Input;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class AssignDefectSteps {
    String defectId;

    @Given("The manager is logged in as a manager")
    public void theManagerIsLoggedInAsAManager() throws InterruptedException {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.theEmployeeIsOnTheLoginPage();
        loginSteps.theEmployeeTypesInIntoTheUsernameInput("g8tor");
        loginSteps.theEmployeeTypesInIntoThePasswordInput("chomp!");
        loginSteps.theEmployeeClicksOnTheLoginButton();
    }

    @Given("The manager is on the home page")
    public void theManagerIsOnTheHomePage() {
        Runner.wait.until(ExpectedConditions.titleContains("Home"));
        Assert.assertTrue(Runner.homePage.title.getAttribute("textContent").contains("Home"));
    }

    @Then("The manager should see pending defects")
    public void theManagerShouldSeePendingDefects() {
        Assert.assertTrue(Runner.homePage.defectTable.isDisplayed());
    }

    @When("The manager clicks on the select button for a defect")
    public void theManagerClicksOnTheSelectButtonForADefect() {
        Runner.wait.until(ExpectedConditions.visibilityOf(Runner.homePage.firstSelect));

        Runner.homePage.firstSelect.click();
    }

    @Then("The defect description should appear in bold")
    public void theDefectDescriptionShouldAppearInBold() {
        String fontWeight = Runner.homePage.selectedDescription.getCssValue("font-weight");
        Assert.assertTrue("bold".equals(fontWeight) || "bolder".equals(fontWeight) || Integer.parseInt(fontWeight) >= 700);
    }

    @When("The manager selects an tester from the drop down")
    public void theManagerSelectsAnTesterFromTheDropDown() {
        Runner.homePage.assignPerson.sendKeys("ryeGuy");
    }

    @When("The manager clicks assign")
    public void theManagerClicksAssign() throws InterruptedException {
        Runner.wait.until(ExpectedConditions.visibilityOf(Runner.homePage.defectIDOne));
        defectId = Runner.homePage.defectIDOne.getText();
        Runner.homePage.assignPersonButton.click();
        Thread.sleep(Duration.ofSeconds(1));
    }

    @Then("The defect should disappear from the list")
    public void theDefectShouldDisappearFromTheList() {
         if(Runner.driver.findElements(By.xpath("//*[@id=\"root\"]/table/tbody/tr/td[3]/button")).size() > 0){
             Assert.assertNotEquals(defectId, Runner.homePage.defectIDOne.getText());
         }
    }

    @Given("The assigned tester is on their home page")
    public void theAssignedTesterIsOnTheirHomePage() {
    }

    @Then("The tester should see the pending defect")
    public void theTesterShouldSeeThePendingDefect() {
        Runner.wait.until(ExpectedConditions.visibilityOf(Runner.homePage.testerCheckID));
        Assert.assertTrue(Runner.homePage.testerCheckID.getText().contains(defectId));
    }

    @When("The user logs out")
    public void theUserLogsOut() {
        Runner.homePage.logoutButton.click();
    }
}
