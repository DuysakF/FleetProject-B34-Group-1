package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.LoginPage;
import com.cydeo.pages.VehiclePage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class VehiclesOdometers_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    VehiclePage vehiclePage = new VehiclePage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
      Driver.getDriver().get("https://qa3.vytrack.com/");


    }
    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        loginPage.username.sendKeys("storemanager51");
        loginPage.password.sendKeys("UserUser123");
        loginPage.loginButton.click();
    }

    @When("user select dropdown Fleets")
    public void user_select_dropdown_fleets() {
//        WebElement fleetButton= Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Fleet']"));
        BrowserUtils.waitForVisibility(basePage.fleetButton, 45);
        BrowserUtils.waitFor(15);


        basePage.fleetButton.click();
    }

    @When("user clicks Vehicle Odometer")
    public void user_clicks_vehicle_odometer() {

//        Driver.getDriver().findElement(By.xpath("//span[.='Vehicle Odometer']")).click();
        basePage.vehicleOdometerButton.click();
    }

    @Then("user should be see page number {int} and view per page {int}")
    public void user_should_be_see_page_number_and_view_per_page(Integer int1, Integer int2) {
//       WebElement pageNumber = Driver.getDriver().findElement(By.xpath("//input[@type='number']"));
//       BrowserUtils.waitForVisibility(pageNumber, 40);

        BrowserUtils.waitForVisibility(vehiclePage.pageNumber, 40);

       String expectedValue= "1";
       String actualValue = vehiclePage.pageNumber.getAttribute("value");

        System.out.println("actualValue = " + actualValue);

        Assert.assertEquals(expectedValue, actualValue);

//        WebElement viewPage = Driver.getDriver().findElement(By.xpath("//button[@class='btn dropdown-toggle ']"));

        System.out.println(vehiclePage.viewPerPage.getText());
        Assert.assertEquals("25", vehiclePage.viewPerPage.getText());
    }

    @Then("user should be see page number {int}")
    public void userShouldBeSeePageNumber(int pageNumber) {
        BrowserUtils.waitForVisibility(vehiclePage.pageNumber, 40);

        String expectedNumber = String.valueOf(pageNumber);
        String actualValue = vehiclePage.pageNumber.getAttribute("value");

        System.out.println("actualValue = " + actualValue);

        Assert.assertEquals(expectedNumber, actualValue);
    }

    @Then("user should be see view per page {int}")
    public void userShouldBeSeeViewPerPage(int viewPerPage) {
        String expectedViewPerPage =  String.valueOf(viewPerPage);

        Assert.assertEquals(expectedViewPerPage, vehiclePage.viewPerPage.getText());
    }

    @Then("Store and Sales managers should see an error message “You do not have permission to perform this action.”")
    public void storeAndSalesManagersShouldSeeAnErrorMessageYouDoNotHavePermissionToPerformThisAction() {



        BrowserUtils.waitFor(10);
          String expectedMessage = "You do not have permission to perform this action.";
          String actualMessage = Driver.getDriver().findElement(By.xpath("//*[contains(text(), 'You do not have')]")).getText();
        System.out.println("actualMessage = " + actualMessage);

        Assert.assertEquals(expectedMessage, actualMessage);
    }
    ////*[contains(text(),'ABC')]

    ////div[normalize-space()='You do not have permission to perform this action.']
}
