package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class FrameTest {

        public WebDriver driver;

        @Test

        public void WindowTestMethod() {

            driver = new ChromeDriver();
            driver.get("https://demoqa.com");

            JavascriptExecutor js = (JavascriptExecutor) driver;
            JavascriptExecutor executor = (JavascriptExecutor) driver;

            driver.manage().window().maximize();

            //wait implicit
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            WebElement alertForm = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
            alertForm.click();

            WebElement frameFormElement = driver.findElement(By.xpath("//span[text()='Frames']"));
            executor.executeScript("arguments[0].click();", frameFormElement);

            //driver.switchTo().frame("frame1");

            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame1']")));

            WebElement firstBlockElement = driver.findElement(By.id("sampleHeading"));
            System.out.println(firstBlockElement.getText());

            driver.switchTo().parentFrame();

            driver.switchTo().frame("frame2");
            WebElement secondBlockElement = driver.findElement(By.id("sampleHeading"));
            System.out.println();
            System.out.println(secondBlockElement.getText());

            driver.quit();

        }

}
