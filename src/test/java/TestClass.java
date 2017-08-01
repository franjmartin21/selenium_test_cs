import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by francisco on 12/30/16.
 */
@Ignore
public class TestClass {
    @Test
    public void test1(){
        System.setProperty("webdriver.gecko.driver","/home/francisco/Trabajo/selenium/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.creditsesame.com");
        driver.close();
        driver.quit();
    }
}
