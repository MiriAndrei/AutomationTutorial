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

        //WebElement alertForm = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        //elementHelper.clickJSElement(alertForm);
        //alertForm.click();

        WebElement alertFormTable = driver.findElement(By.xpath("//span[text()='Alerts']"));
        elementHelper.clickJSElement(alertFormTable);
        //alertFormTable.click();

        WebElement alertOkButtonElement= driver.findElement(By.id("alertButton"));
        elementHelper.clickElement(alertOkButtonElement);
        alertHelper.acceptAlert();
        //alertOkButtonElement.click();

        WebElement alertsWaitButtonElement = driver.findElement(By.id("timerAlertButton"));
        elementHelper.clickElement(alertsWaitButtonElement);
        alertHelper.acceptAlert();
        //alertsWaitButtonElement.click();
        //wait explicit pentru alerta
        //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.alertIsPresent());

        WebElement alertOkCancelElement = driver.findElement(By.id("confirmButton"));
        elementHelper.clickElement(alertOkCancelElement);
        alertHelper.dismissAlert();

        WebElement alertPromtElement = driver.findElement(By.id("promtButton"));
        elementHelper.clickElement(alertPromtElement);
        alertHelper.fillAlert("Andrei");
    }
}
