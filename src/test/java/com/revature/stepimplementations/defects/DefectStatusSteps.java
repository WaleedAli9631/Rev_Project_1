package com.revature.stepimplementations.defects;

import com.revature.runners.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class DefectStatusSteps {
    String nonUpdatedStatus;
    @Given("The tester is on the Home Page")
    public void theTesterIsOnTheHomePage() {
        Runner.wait.until(ExpectedConditions.titleContains("Tester"));
    }

    @Then("The tester {string} can can see only defects assigned to them")
    public void theTesterCanCanSeeOnlyDefectsAssignedToThem(String name) throws InterruptedException {
        List<WebElement> myDefects = Runner.driver.findElements(By.xpath("//*/li"));
        for (WebElement element : myDefects
        ) {
            Runner.wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
            Thread.sleep(Duration.ofSeconds(1));
        }
        List<WebElement> assignedTo = Runner.driver.findElements(By.xpath("//div/p[5]"));
        for (WebElement element : assignedTo
        ) {
            Assert.assertTrue(element.getText().contains(name));
            Thread.sleep(Duration.ofSeconds(1));

        }
    }

    @When("The tester changes to defect to any status")
    public void theTesterChangesToDefectToAnyStatus() {
        Runner.homePage.firstChangeStatus.click();
        Random rand = new Random();
        int randomNum = rand.nextInt((5 - 1) + 1) + 1;
        String xpath = String.format("//*/div/button[%s]",randomNum);
        WebElement randomStatus = Runner.driver.findElement(By.xpath(xpath));
        while(randomStatus.getText().equals(Runner.homePage.firstStatus.getText())){
            randomNum = rand.nextInt((5 - 1) + 1) + 1;
            xpath = String.format("//*/div/button[%s]",randomNum);
            randomStatus = Runner.driver.findElement(By.xpath(xpath));
        }
        nonUpdatedStatus = Runner.homePage.firstStatus.getText();
        randomStatus.click();
    }

    @Then("The tester should see the defect has a different status")
    public void theTesterShouldSeeTheDefectHasADifferentStatus() throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(1));

        Assert.assertNotEquals(nonUpdatedStatus,Runner.homePage.firstStatus.getText());
    }
}
