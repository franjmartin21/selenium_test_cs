import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;


public class ParalellTest implements Runnable {

    private static final String URL = "https://perf.creditsesame.com/login";

    private static final int NUM_THREADS = 10;

    private static final int NUM_ITERATIONS = 10;

    private Set<String> sessionsUsed;

    private static List<Thread> threadList = new ArrayList<Thread>();

    private static List<Set<String>> sessionSetList = new ArrayList<Set<String>>();

    public ParalellTest(Set<String> sessionsUsed){
        this.sessionsUsed = sessionsUsed;
    }

    public void run() {
        FirefoxOptions options = new FirefoxOptions()
                .setLogLevel(Level.OFF);
        WebDriver driver = new FirefoxDriver(options);
        for(int i = 0; i < NUM_ITERATIONS; i++){
            try {
                driver.get(URL);
                driver.get(URL);
                sessionsUsed.add(driver.manage().getCookieNamed("JSESSIONID").getValue());
                JavascriptExecutor executor = (JavascriptExecutor)driver;
                executor.executeScript("document.getElementsByName('email')[0].value='test1@creditsesame.com'");
                executor.executeScript("document.getElementsByName('password')[0].value='password'");
                executor.executeScript("document.getElementById('loginButton').click()");
                Thread.sleep(2000);
                sessionsUsed.add(driver.manage().getCookieNamed("JSESSIONID").getValue());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String [] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","/home/francisco/Trabajo/selenium/geckodriver");
        for(int i = 0; i < NUM_THREADS; i++){
            Set<String> sessionsUsed = new HashSet<String>();
            Thread thread = new Thread(new ParalellTest(sessionsUsed));
            thread.start();
            threadList.add(thread);
            sessionSetList.add(sessionsUsed);
        }

        for(int i = 0; i < threadList.size(); i++){
            threadList.get(i).join();
        }


        checkSets(sessionSetList);
    }
    private static void checkSets(List<Set<String>> sessionSetList){
        for(Set<String> setSelected: sessionSetList){
            for(Set setComparing:sessionSetList){
                System.out.println(setComparing);
                if(setComparing == setSelected) continue;

                for(String value: setSelected){
                    if(setComparing.contains(value)){
                        System.out.println("The value " + value + " appears in more than one set");
                    }
                }
            }
        }
    }
}
