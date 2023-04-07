package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BaseTest {
    public WebDriver driver;
    public FirefoxOptions options; 

    String username = "standard_user";
    String password = "secret_sauce";

    @Before
    public void setUp(){
        options = new FirefoxOptions();
        // options.addArguments("-headless");
        
        driver = new FirefoxDriver(options);
        // driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
    
}
