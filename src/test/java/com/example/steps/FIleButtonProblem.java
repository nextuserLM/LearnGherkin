package com.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class FIleButtonProblem {
    WebDriver driver;

    @Given("the user is on the automation practice form page")
    public void the_user_is_on_the_automation_practice_form_page() {
        System.setProperty("webdriver.firefox.driver", "C:\\Users\\Dell\\Desktop\\DevTools\\FirefoxDriver\\geckodriver.exe"); // Update this with the correct path to your geckodriver

        // Configure Firefox with the uBlock Origin extension
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(new FirefoxProfile(new File("C:\\Users\\Dell\\Desktop\\DevTools\\FirefoxDriver\\ProfileTest"))); // Update this with the correct path to your custom Firefox profile
        FirefoxProfile profile = new FirefoxProfile();
        File ublockOriginXpi = new File("C:\\Users\\Dell\\Desktop\\DevTools\\FirefoxDriver\\uBlock0_1.47.5rc6.firefox.signed.xpi"); // Update this with the correct path to your uBlock Origin XPI file
        profile.addExtension(ublockOriginXpi);
        options.setProfile(profile);

        // Initialize FirefoxDriver with the configured options
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/automation-practice-form");
    }

//    @Given("the user is on the automation practice form page")
//    public void the_user_is_on_the_automation_practice_form_page() {
//        System.setProperty("webdriver.firefox.driver", "C:\\Users\\Dell\\Desktop\\DevTools\\FirefoxDriver\\geckodriver.exe"); // Update this with the correct path to your geckodriver
//        driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("https://demoqa.com/automation-practice-form");
//    }

    @When("the user clicks the Przegladaj button")
    public void the_user_clicks_the_przegladaj_button() {
//        WebElement fileButton = driver.findElement(By.id("uploadPicture"));
//        fileButton.click();
//    }
        WebElement fileButton = driver.findElement(By.id("uploadPicture"));
        String filePath = "C:\\Users\\Dell\\Desktop\\Text.txt";
        fileButton.sendKeys(filePath);
    }

    @Then("the form should be submitted")
    public void the_form_should_be_submitted() {
        // Add any necessary assertions or validations to check if the form was submitted
//        driver.quit();
    }
}
