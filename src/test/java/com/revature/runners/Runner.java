package com.revature.runners;

import com.revature.pages.*;
import com.revature.stepimplementations.login.LoginSteps;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import javax.swing.*;
import java.time.Duration;

@CucumberOptions(features = "classpath:features", glue = "com.revature.stepimplementations")

public class Runner extends AbstractTestNGCucumberTests {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static HomePage homePage;

    public static MatricesPage matricesPage;

    public static TestCaseEditor testCaseEditor;

    public static DefectReporterPage defectReporterPage;
    public static TestCasePage testCasePage;
    public static WebDriverWait wait;

    public static String titleString;
    public static Actions action;
    static public void quickLogin(String username, String password) throws InterruptedException {
        LoginSteps loginSteps = new LoginSteps();

        loginSteps.theEmployeeTypesInIntoTheUsernameInput(username);
        loginSteps.theEmployeeTypesInIntoThePasswordInput(password);
        loginSteps.theEmployeeClicksOnTheLoginButton();
    }

    static public void quickLogOut() throws InterruptedException {
        Runner.homePage.logoutButton.click();
        Thread.sleep(Duration.ofSeconds(1));
    }

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        wait = new WebDriverWait(Runner.driver, Duration.ofSeconds(2));

        action = new Actions(driver);

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        matricesPage = new MatricesPage(driver);
        testCasePage = new TestCasePage(driver);
        testCaseEditor = new TestCaseEditor(driver);
        defectReporterPage = new DefectReporterPage(driver);
    }

    @AfterMethod
    public void cleanup() {
        driver.quit();
    }
}
