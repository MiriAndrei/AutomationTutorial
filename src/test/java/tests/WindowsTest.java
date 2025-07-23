package tests;

import helperMethods.ElementHelper;
import helperMethods.PageHelper;
import helperMethods.TabHelper;
import helperMethods.WindowsHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class WindowsTest extends SharedData {


    @Test

    public void testMethod() {
        PageHelper pageHelper = new PageHelper(getDriver());
        ElementHelper elementHelper = new ElementHelper(getDriver());
        WindowsHelper windowsHelper = new WindowsHelper(getDriver());
        TabHelper tabHelper = new TabHelper(getDriver());

        pageHelper.scrollPage(0, 400);

        WebElement alertForm = getDriver().findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementHelper.clickElement(alertForm);

        WebElement alertFormTable = getDriver().findElement(By.xpath("//span[text()='Browser Windows']"));
        elementHelper.clickElement(alertFormTable);

        WebElement newTabElement = getDriver().findElement(By.id("tabButton"));
        elementHelper.clickElement(newTabElement);

        tabHelper.switchToSpecificTab(1);
        tabHelper.closeCurrentTab();
        tabHelper.switchToSpecificTab(0);

        WebElement newWindowElement = getDriver().findElement(By.id("windowButton"));
        elementHelper.clickElement(newWindowElement);

        tabHelper.switchToSpecificTab(1);
        tabHelper.closeCurrentTab();
        tabHelper.switchToSpecificTab(0);

        //driver.quit();
        //din cauza reclamei fortam site-ul sa acceseze un URL specific
        //driver.navigate().to("www.google.com");
    }
}
