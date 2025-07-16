package tests;

import helperMethods.AlertHelper;
import helperMethods.ElementHelper;
import helperMethods.PageHelper;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import pages.IndexPage;
import sharedData.SharedData;

public class AlertsTest extends SharedData {

    @Test

    public void WindowTestMethod() {

        ElementHelper elementHelper = new ElementHelper(driver);
        AlertHelper alertHelper = new AlertHelper(driver);
        PageHelper pageHelper = new PageHelper(driver);

        IndexPage indexPage = new IndexPage(driver);
        indexPage.interactOnAlertsFraneWindowMenu();

        WebElement alertFormTable = driver.findElement(By.xpath("//span[text()='Alerts']"));
        elementHelper.clickJSElement(alertFormTable);

        WebElement alertOkButtonElement= driver.findElement(By.id("alertButton"));
        elementHelper.clickElement(alertOkButtonElement);
        alertHelper.acceptAlert();

        WebElement alertsWaitButtonElement = driver.findElement(By.id("timerAlertButton"));
        elementHelper.clickElement(alertsWaitButtonElement);
        alertHelper.acceptAlert();

        WebElement alertOkCancelElement = driver.findElement(By.id("confirmButton"));
        elementHelper.clickElement(alertOkCancelElement);
        alertHelper.dismissAlert();

        WebElement alertPromtElement = driver.findElement(By.id("promtButton"));
        elementHelper.clickElement(alertPromtElement);
        alertHelper.fillAlert("Andrei");
    }
}
