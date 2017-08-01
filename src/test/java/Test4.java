import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;


@Ignore
public class Test4 {

  @Before
  public void setUp() throws Exception {
      System.setProperty("webdriver.gecko.driver","/home/francisco/Trabajo/selenium/geckodriver");
  }

  @Test
  public void driverIsTheKing() throws Exception {
      WebDriver webDriver = new FirefoxDriver();
      webDriver.get("http://www.compendiumdev.co.uk/selenium");
      assertTrue(webDriver.getTitle().startsWith("Selenium Simplified"));
  }

  @Test
  public void firefoxIsSupportedByWebDriver(){
      WebDriver driver = new FirefoxDriver();
      driver.get("http://compendiumdev.co.uk/selenium");
      assertTrue(true);

  }
}
