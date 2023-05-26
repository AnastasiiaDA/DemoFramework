package com.anastasiia.stepDefs;

import com.anastasiia.pages.JewelryAccessPage;
import com.anastasiia.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class search_stepDefinitions {

    JewelryAccessPage jewelryAccessPage;
    @Given("user is on Etsy home page")
    public void user_is_on_etsy_home_page() {
        Driver.getDriver().navigate().to("https://www.etsy.com");
    }
    @When("user enters {string} into search box")
    public void user_enters_into_search_box(String itemName) {
        jewelryAccessPage = new JewelryAccessPage();
        jewelryAccessPage.searchBox.sendKeys(itemName);
    }
    @When("clicks enter")
    public void clicks_enter() {
        jewelryAccessPage.searchBox.sendKeys(Keys.ENTER);
    }
    @Then("user should see {string} in title")
    public void user_should_see_in_title(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

}
