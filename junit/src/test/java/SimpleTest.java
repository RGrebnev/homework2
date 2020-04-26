import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SimpleTest {
    protected static WebDriver driver;
    private final static Logger logger = LogManager.getLogger("JUnit tests");
    TestConfig cfg = ConfigFactory.create(TestConfig.class);

    @Before
    public void setUp() {
        String browserType = System.getProperty("browser");
        if (browserType == null) browserType = "chrome"; //default browser (without argument)
        driver = WebDriverFactory.createNewDriver(browserType);
        /*
        //create driver with options
        FirefoxOptions options = new FirefoxOptions();
        driver = WebDriverFactory.createNewDriver("firefox", options);
         */
        logger.info("Driver is up");
    }

    @Test
    public void openPage(){
        driver.get(cfg.url());
        logger.info("Otus page open");
    }

    @After
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
