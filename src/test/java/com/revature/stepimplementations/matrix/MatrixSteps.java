package com.revature.stepimplementations.matrix;

import com.revature.runners.Runner;
import com.revature.stepimplementations.login.LoginSteps;
import com.revature.stepimplementations.navigation.NavigationSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Duration;
import java.util.Random;

public class MatrixSteps {
//    @Given("A manager is on their home page")
//    public void aManagerIsOnTheirHomePage() {
//        throw new io.cucumber.java.PendingException();
//    }

    @Then("A manager can pull up a form to make a new matrix")
    public void aManagerCanPullUpAFormToMakeANewMatrix() {
        Runner.wait.until(ExpectedConditions.titleContains("Home"));
        Runner.homePage.createNewRTM.click();
        Runner.wait.until(ExpectedConditions.visibilityOf(Runner.homePage.matrixTitle));
    }

    @When("A manager creates a title for a matrix")
    public void aManagerCreatesATitleForAMatrix() throws InterruptedException {

        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 6;
        Random random = new Random();

        Runner.titleString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        Runner.homePage.matrixTitle.sendKeys(Runner.titleString);
        Thread.sleep(Duration.ofSeconds(1));

    }

    @When("A manager adds requirements to a matrix")
    public void aManagerAddsRequirementsToAMatrix() throws InterruptedException {
        Runner.homePage.addRequirement.click();
        //need to verify that it actually added
        Thread.sleep(Duration.ofSeconds(1));

    }

    @When("A manager saves a matrix")
    public void aManagerSavesAMatrix() throws InterruptedException {
        Runner.homePage.saveMatrix.click();
        Thread.sleep(Duration.ofSeconds(1));
        Runner.driver.switchTo().alert().accept();
        Thread.sleep(Duration.ofSeconds(1));

    }


    @Then("The matrix should be visible for all testers and managers")
    public void theMatrixShouldBeVisibleForAllTestersAndManagers() throws InterruptedException {
        NavigationSteps navigationSteps = new NavigationSteps();
        // If unable to find element an exception will be thrown
        //Check manager new matrix visibility
        String titleXpath = "//*[@id=\"root\"]/ul/li[contains(text(),'" + Runner.titleString + "')]";
        Runner.quickLogOut();
        Runner.quickLogin("g8tor", "chomp!");
        navigationSteps.theManagerClicksOnMatrices();
        Thread.sleep(Duration.ofSeconds(1));

        WebElement matrix = Runner.driver.findElement(By.xpath(titleXpath));

        // Making sure it is displayed
        Assert.assertTrue((matrix.isDisplayed())
        );
        //Check tester new matrix visibility
        Runner.quickLogOut();
        Runner.quickLogin("ryeGuy", "coolbeans");
        navigationSteps.theManagerClicksOnMatrices();
        navigationSteps.theManagerClicksOnMatrices();
        matrix = Runner.driver.findElement(By.xpath(titleXpath));
        Assert.assertTrue((matrix.isDisplayed())
        );

    }

    @Given("A manager or tester has selected a matrix")
    public void aManagerOrTesterHasSelectedAMatrix() throws InterruptedException {
        Runner.matricesPage.firstShowMatrix.click();
        Thread.sleep(Duration.ofSeconds(1));

    }

    @When("A manager or tester adds or removes defects")
    public void aManagerOrTesterAddsOrRemovesDefects() throws InterruptedException {
        //need to verify that it actually added

        Runner.matricesPage.firstEdit.click();
        Runner.matricesPage.defectAddButton.click();
        Runner.matricesPage.defectRemoveButton.click();
        Thread.sleep(Duration.ofSeconds(1));


    }

    @When("A manager or tester confirms their changes")
    public void aManagerOrTesterConfirmsTheirChanges() throws InterruptedException {
        Runner.matricesPage.saveRequirement.click();
        Thread.sleep(Duration.ofSeconds(1));

    }

    @Then("Then the matrix should saved")
    public void thenTheMatrixShouldSaved() throws InterruptedException {
        Runner.wait.until(ExpectedConditions.alertIsPresent());
        String actualText = Runner.driver.switchTo().alert().getText();
        Assert.assertEquals("Matrix Saved", actualText);
        Runner.driver.switchTo().alert().accept();
        Thread.sleep(Duration.ofSeconds(1));

    }

    @When("A manager or tester adds or removes Test Cases")
    public void aManagerOrTesterAddsOrRemovesTestCases() throws InterruptedException {
        //need to verify that it actually added

        Runner.matricesPage.firstEdit.click();
        Runner.matricesPage.testCaseAddButton.click();
        Runner.matricesPage.testCaseRemoveButton.click();
        Thread.sleep(Duration.ofSeconds(1));
    }
}
