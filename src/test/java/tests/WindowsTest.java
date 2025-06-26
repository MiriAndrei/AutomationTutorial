package tests;

import helperMethods.ElementHelper;
import helperMethods.PageHelper;
import helperMethods.WindowsHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class WindowsTest extends SharedData {


    @Test

    public void testMethod() {
        PageHelper pageHelper = new PageHelper(driver);
        ElementHelper elementHelper = new ElementHelper(driver);
        WindowsHelper windowsHelper = new WindowsHelper(driver);

        pageHelper.scrollPage(0,400);

        WebElement alertForm = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementHelper.clickElement(alertForm);

        WebElement alertFormTable = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        elementHelper.clickElement(alertFormTable);

        WebElement newTabElement = driver.findElement(By.id("tabButton"));
        elementHelper.clickElement(newTabElement);

        System.out.println(driver.getCurrentUrl());

        windowsHelper.switchToWindow(1);
        System.out.println(driver.getCurrentUrl());

        driver.close();
        windowsHelper.switchToWindow(0);

        WebElement newWindowElement= driver.findElement(By.id("windowButton"));
        elementHelper.clickElement(newWindowElement);
        System.out.println(driver.getCurrentUrl());

        windowsHelper.switchToWindow(1);
        System.out.println(driver.getCurrentUrl());

        driver.close();
        windowsHelper.switchToWindow(0);
        System.out.println(driver.getCurrentUrl());

        //driver.quit();
        //din cauza reclamei fortam site-ul sa acceseze un URL specific
        //driver.navigate().to("www.google.com");
    }
}
