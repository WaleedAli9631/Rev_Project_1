package com.revature.stepimplementations.login;

import com.revature.runners.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class LoginSteps {
    @Given("The employee is on the login page")
    public void theEmployeeIsOnTheLoginPage() {
        Runner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=22");
    }

    @When("The employee types in {string} into the username input")
    public void theEmployeeTypesInIntoTheUsernameInput(String arg0) {
        Runner.loginPage.usernameInput.sendKeys(arg0);
    }

    @When("The employee types in {string} into the password input")
    public void theEmployeeTypesInIntoThePasswordInput(String arg0) {
        Runner.loginPage.passwordInput.sendKeys(arg0);
    }

    @When("The employee clicks on the login button")
    public void theEmployeeClicksOnTheLoginButton() throws InterruptedException {
        Runner.loginPage.loginButton.click();
    }

    @Then("The employee should see an alert saying they have the wrong password")
    public void theEmployeeShouldSeeAnAlertSayingTheyHaveTheWrongPassword() {
        Runner.wait.until(ExpectedConditions.alertIsPresent());
        String actualText = Runner.driver.switchTo().alert().getText();
        Assert.assertEquals(actualText, "Wrong password");
    }

    @Then("The employee should see an alert saying no user with that username found")
    public void theEmployeeShouldSeeAnAlertSayingNoUserWithThatUsernameFound() {
        Runner.wait.until(ExpectedConditions.alertIsPresent());
        String actualText = Runner.driver.switchTo().alert().getText();
        Assert.assertEquals(actualText, "Username not found");
    }

    @Then("the employee should be on the {string} page")
    public void theEmployeeShouldBeOnTheRolePage(String role) {
        Runner.wait.until(ExpectedConditions.titleContains(role));
        Assert.assertTrue(Runner.homePage.title.getAttribute("textContent").contains(role));
    }

    @Then("The employee should see their name {string} {string} on the home page")
    public void theEmployeeShouldSeeTheirNameFnameLnameOnTheHomePage(String fname, String lname) {
        String[] nameCheck = Runner.homePage.welcomeMessage.getText().split("\\s+");
        Assert.assertEquals(nameCheck[1].toUpperCase(), fname.toUpperCase());
        Assert.assertEquals(nameCheck[2].toUpperCase(), lname.toUpperCase());

    }

}
