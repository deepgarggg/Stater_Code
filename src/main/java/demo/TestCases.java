package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-left']")));
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//*[contains(text(),'LEFT')]")).getText());
        driver.switchTo().parentFrame();
        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//*[contains(@id,'content')]")).getText());
        driver.switchTo().parentFrame();
        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-right']")));
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//*[contains(text(),'RIGHT')]")).getText());
        driver.switchTo().parentFrame();
        Thread.sleep(2000);
        driver.switchTo().parentFrame();
        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-bottom']")));
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//*[contains(text(),'BOTTOM')]")).getText());
        driver.switchTo().parentFrame();

        System.out.println("end Test case: testCase01");
    }


}
