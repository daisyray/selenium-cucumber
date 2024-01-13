package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.LandingPage;
import utils.TestContextSetup;

import java.util.*;

public class LandingPageStepDefinition {
    String landingPageProductName;
    TestContextSetup testContextSetup;
    public LandingPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }
    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() {
        testContextSetup.driver = new ChromeDriver();
        testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

    }
    @When("user searched with Shortname {string} and extracted actual name of product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortname) throws InterruptedException {
        LandingPage landingPage = testContextSetup.pageObjectManager.landingPage;
        landingPage.searchItem(shortname);
        Thread.sleep(5000);
        testContextSetup.landingPageProductName = landingPage.getProductName();
        System.out.println(landingPageProductName + "is exctracted from Home page");
    }

}
