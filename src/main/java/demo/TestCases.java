package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;

import javax.print.DocFlavor;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.makemytrip.com/");
        try {
            driver.getCurrentUrl().contains("makemytrip");
            System.out.println("Homepage url contains the given string");
            System.out.println("TestCase 01 PASSED");
        }
        catch(Exception e) {
            System.out.println("Something went wrong");
        }

    }

    public void testCase02() throws InterruptedException {
        System.out.println("Start Test case: testCase02");
        try {
            WebElement bangal = driver.findElement(By.xpath("//label[@for='fromCity']"));
            bangal.click();
            driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("blr");
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@class='calc60']/p[contains(text(),'Bengaluru')]")).click();
            Thread.sleep(1000);

            driver.findElement(By.xpath("//label[@for='toCity']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("del");
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div/p[contains(text(),'New Delhi')]")).click();
            Thread.sleep(3000);

            driver.findElement(By.xpath("//span[text()='Departure']")).click();
            Thread.sleep(1000);
            if(driver.findElement(By.xpath("//div[contains(text(),'January')]")).getText().contains("January 2024")){
                driver.findElement(By.xpath("//div[@aria-label='Sat Jan 20 2024']")).click();
            }

            Thread.sleep(3000);

            driver.findElement(By.xpath("//a[text()='Search']")).click();
            Thread.sleep(8000);
            List<WebElement> flightPrices = driver.findElements(By.xpath("//div[contains(@class,'clusterViewPrice')]"));
//            String prices = "per adult";
            List<String> maList = new ArrayList<>();
            for(WebElement elem : flightPrices){
                maList.add(elem.getText());
//                prices = prices + elem.getText();
            }
            System.out.println("Flight Prices list: "+maList);
            System.out.println("TestCase 02 PASSED");
        }
        catch(Exception e) {
            System.out.println("Something went wrong");
        }
    }

    public  void testCase03(){
        System.out.println("Start Test case: testCase03");
        try {
//            driver.get("https://www.makemytrip.com/");
            driver.findElement(By.xpath("//a[@href='https://www.makemytrip.com/railways/']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//label[@for='fromCity']")).click();
            driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("ypr");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[text()='Bengaluru - All Stations']")).click();
            Thread.sleep(2000);

            driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("ndls");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[text()='Delhi - All Stations']")).click();
            Thread.sleep(2000);
            if(driver.findElement(By.xpath("//div[contains(text(),'January')]")).getText().contains("January 2024")){
                driver.findElement(By.xpath("//div[@aria-label='Sat Jan 20 2024']")).click();
            }
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[@data-cy='3A']")).click();

            driver.findElement(By.xpath("//a[text()='Search']")).click();
            Thread.sleep(8000);
            //div[@class='rail-class' and text()='3A']/../following-sibling::div
            List<WebElement> railPrice = driver.findElements(By.xpath("//div[@class='rail-class' and text()='3A']/../following-sibling::div"));
            String price = "";
            List<String> maList = new ArrayList<>();
            for(WebElement elem : railPrice){
                maList.add(elem.getText());
                price = price + elem.getText();
            }

            System.out.println("3AC Train Price list: "+maList);
            System.out.println("TestCase 03 PASSED");
        }
        catch(Exception e) {
            System.out.println("Something went wrong");
        }

    }

    public  void testCase04(){
        System.out.println("Start Test case: testCase04");
        try {
//            driver.get("https://www.makemytrip.com/");
            driver.findElement(By.xpath("//a[@href='https://www.makemytrip.com/bus-tickets/']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//label[@for='fromCity']")).click();
            driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("bangl");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[text()='Bangalore, Karnataka']")).click();
            Thread.sleep(2000);

            driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("del");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[text()='Delhi']")).click();
            Thread.sleep(2000);
            if(driver.findElement(By.xpath("//div[contains(text(),'January')]")).getText().contains("January 2024")){
                driver.findElement(By.xpath("//div[@aria-label='Sat Jan 20 2024']")).click();
            }
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[@id='search_button']")).click();
            Thread.sleep(8000);

            if(driver.findElement(By.xpath("//span[@class='error-title']")).getText().equals("No buses found for 20 Jan")){
                System.out.println("No buses found for 20 Jan - Text message displayed correctly");
            }

            System.out.println("TestCase 04 PASSED");
        }
        catch(Exception e) {
            System.out.println("Something went wrong");
        }

    }


}
