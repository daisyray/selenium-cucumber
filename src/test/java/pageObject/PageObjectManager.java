package pageObject;

import io.cucumber.java.jv.Lan;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    public LandingPage landingPage;
    public WebDriver driver;
    public OffersPage offersPage;
    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }
    public LandingPage getLandingPage() {
        landingPage = new LandingPage(driver);
        return landingPage;
    }
    public OffersPage getOffersPage() {
        offersPage = new OffersPage(driver);
        return offersPage;
    }
}
