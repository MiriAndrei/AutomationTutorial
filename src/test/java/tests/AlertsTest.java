package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertsTest {
    public WebDriver driver;

    @Test

    public void WindowTestMethod() {

        driver = new ChromeDriver();
        driver.get("https://demoqa.com");

        driver.manage().window().maximize();

        //wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement alertForm = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertForm.click();

        WebElement alertFormTable = driver.findElement(By.xpath("//span[text()='Alerts']"));
        alertFormTable.click();

        WebElement alertOkButtonElement= driver.findElement(By.id("alertButton"));
        alertOkButtonElement.click();

        Alert alertOk = driver.switchTo().alert();
        alertOk.accept();

        WebElement alertsWaitButtonElement = driver.findElement(By.id("timerAlertButton"));
        alertsWaitButtonElement.click();

        //wait explicit pentru alerta
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alertWait = driver.switchTo().alert();
        alertWait.accept();

        WebElement alertOkCancelElement = driver.findElement(By.id("confirmButton"));
        alertOkCancelElement.click();

        Alert alertOkCancel = driver.switchTo().alert();
        alertOkCancel.dismiss();

        WebElement alertPromtElement = driver.findElement(By.id("promtButton"));
        alertPromtElement.click();

        Alert alertPromt = driver.switchTo().alert();
        alertPromt.sendKeys("Andrei");
        alertPromt.accept();

        driver.quit();

    }
}
