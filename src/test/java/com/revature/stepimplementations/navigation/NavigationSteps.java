package com.revature.stepimplementations.navigation;

import com.revature.runners.Runner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Duration;

public class NavigationSteps {
    @Then("The manager should see links for Matrices, Test Cases, Defect Reporting and Defect Overview")
    public void theManagerShouldSeeLinksForMatricesTestCasesDefectReportingAndDefectOverview() {
        Assert.assertTrue(Runner.homePage.matricesLink.isDisplayed());
        Assert.assertTrue(Runner.homePage.testCasesLink.isDisplayed());
        Assert.assertTrue(Runner.homePage.defectReportingLink.isDisplayed());
        Assert.assertTrue(Runner.homePage.defectOverviewLink.isDisplayed());
    }

    @When("The manager or tester clicks on Matrices")
    public void theManagerClicksOnMatrices() throws InterruptedException {
        Runner.wait.until(ExpectedConditions.visibilityOf(Runner.homePage.matricesLink));

        Runner.homePage.matricesLink.click();
        Thread.sleep(Duration.ofSeconds(1));
    }

    @Then("The title of the page should be Matrix Page")
    public void theTitleOfThePageShouldBeMatrixPage() {
        String titleCheck = Runner.matricesPage.title.getAttribute("textContent").split("\\s+")[0];
        Assert.assertEquals(titleCheck.toUpperCase(), "Matrix".toUpperCase());
    }

    @When("The manager clicks the browser back button")
    public void theManagerClicksTheBrowserBackButton() {
        Runner.driver.navigate().back();
    }

    @Then("The manager should be on the home page and the title of page is Home")
    public void theManagerShouldBeOnTheHomePageAndTheTitleOfPageIsHome() {
        String titleCheck = Runner.homePage.title.getAttribute("textContent").split("\\s+")[1];
        Assert.assertEquals(titleCheck.toUpperCase(), "Home".toUpperCase());
    }

    @When("The manager clicks on Test Cases")
    public void theManagerClicksOnTestCases() throws InterruptedException {
        Runner.wait.until(ExpectedConditions.visibilityOf(Runner.homePage.testCasesLink));
        Runner.homePage.testCasesLink.click();
        Thread.sleep(Duration.ofSeconds(1));
    }

    @Then("The title of page should be {string}")
    public void theTitleOfPageShouldBeTitle(String title) {
        Assert.assertTrue(Runner.testCasePage.title.getAttribute("textContent").equals(title));
    }

    @When("The manager clicks on {string}")
    public void theManagerClicksOnLink(String linkText) throws InterruptedException {
        WebElement link = Runner.driver.findElement(By.linkText(linkText));
        Assert.assertTrue(link.isDisplayed());
        link.click();
        Thread.sleep(Duration.ofSeconds(1));

    }
}

