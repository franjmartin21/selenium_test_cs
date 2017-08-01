import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


@Ignore
public class Test3 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.gecko.driver","/home/francisco/Trabajo/selenium/geckodriver");
    driver = new FirefoxDriver();
    baseUrl = "http://local.creditsesame.com:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test3() throws Exception {
    driver.get(baseUrl + "/s/login#index-log-in-top");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("test1@creditsesame.com");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("emer_cs_ITO21");
    driver.findElement(By.linkText("How to convert commands recorded in selenium IDE to Java? - Stack ...")).click();
    driver.findElement(By.id("loginButton")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
