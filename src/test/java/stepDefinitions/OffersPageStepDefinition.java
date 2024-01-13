package stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObject.LandingPage;
import pageObject.OffersPage;
import pageObject.PageObjectManager;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

public class OffersPageStepDefinition {
    PageObjectManager pageObjectManager;
    String offerPageProductName;
    TestContextSetup testContextSetup;
    public OffersPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("user searched for {string} shortname in offers page")
    public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist(String shortname) {
        switchToOffersPage();
        OffersPage offersPage = testContextSetup.pageObjectManager.offersPage;
        offersPage.searchItem(shortname);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        offerPageProductName = offersPage.getProductName();
    }
    @Then("validate product name in offers page matches with Landing Page")
    public void validate_product_name_in_offers_page() {
        Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
    }

    public void switchToOffersPage() {
        LandingPage landingPage = testContextSetup.pageObjectManager.landingPage;
        landingPage.selectTopDeals();
        testContextSetup.genericUtils.switchWindowToChild();
    }
}
