package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;

    public WebDriver WebDriverManager() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//global.properties");

        Properties prop = new Properties();
        prop.load(fis);
        String url = prop.getProperty("QAUrl");
        String browser_properties = prop.getProperty("browser");

        if (driver == null) {
            if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            }
            if ( prop.getProperty("broser").equals("firefox")) {
                // open firefox browser
            }
            driver.get(url);
        }
        return driver;
    }
}
