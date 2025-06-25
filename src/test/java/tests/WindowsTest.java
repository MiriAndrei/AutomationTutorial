package tests;

import helperMethods.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WindowsTest extends SharedData {


    @Test

    public void testMethod() {
        PageHelper pageHelper = new PageHelper(driver);

        pageHelper.scrollPage(0,400);



        WebElement alertForm = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertForm.click();

        WebElement alertFormTable = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        alertFormTable.click();

        WebElement newTabElement = driver.findElement(By.id("tabButton"));
        newTabElement.click();

        System.out.println(driver.getCurrentUrl());

        List<String> tabsList= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsList.get(1));
        System.out.println(driver.getCurrentUrl());

        //driver.quit();
        driver.close();
        driver.switchTo().window(tabsList.get(0));
        System.out.println(driver.getCurrentUrl());

        WebElement newWindowElement= driver.findElement(By.id("windowButton"));
        newWindowElement.click();

        System.out.println(driver.getCurrentUrl());

        List<String> windowList= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        System.out.println(driver.getCurrentUrl());

        driver.close();
        driver.switchTo().window(tabsList.get(0));
        System.out.println(driver.getCurrentUrl());

        //driver.quit();
        //din cauza reclamei fortam site-ul sa acceseze un URL specific
        //driver.navigate().to("www.google.com");
    }
}
