import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

@Ignore
public class CreditSesameTest {

  @Before
  public void setUp() throws Exception {
      System.setProperty("webdriver.gecko.driver","/home/francisco/Trabajo/selenium/geckodriver");
  }

  @Test
  public void testCSCookie(){
      WebDriver driver = new FirefoxDriver();
      for(int i = 0; i < 100; i++){
          driver.get("http://local.creditsesame.com:8080/s/login");
          System.out.println("Session 1: " + driver.manage().getCookieNamed("JSESSIONID"));

      }
      WebDriver driver2 = new FirefoxDriver();
      for(int i = 0; i < 100; i++) {
          driver2.get("http://local.creditsesame.com:8080/s/login");
          System.out.println("Session 2: " + driver2.manage().getCookieNamed("JSESSIONID"));
      }
      assertTrue(true);
  }
}
