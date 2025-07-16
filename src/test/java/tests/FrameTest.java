package tests;

import helperMethods.ElementHelper;
import helperMethods.FrameHelper;
import helperMethods.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.IndexPage;
import sharedData.SharedData;

public class FrameTest extends SharedData {


    @Test

    public void WindowTestMethod() {

        PageHelper pageHelper = new PageHelper(driver);
        ElementHelper elementHelper = new ElementHelper(driver);
        FrameHelper frameHelper = new FrameHelper(driver);
        IndexPage indexPage = new IndexPage(driver);
        indexPage.interactOnAlertsFraneWindowMenu();

        WebElement frameFormElement = driver.findElement(By.xpath("//span[text()='Frames']"));
        elementHelper.clickJSElement(frameFormElement);

        frameHelper.switchFrameByElement(driver.findElement(By.xpath("//iframe[@id='frame1']")));

        WebElement firstBlockElement = driver.findElement(By.id("sampleHeading"));
        elementHelper.printTextElement(firstBlockElement);

        frameHelper.switchToParent();
        frameHelper.switchFrameByString("frame2");

        WebElement secondBlockElement = driver.findElement(By.id("sampleHeading"));
        elementHelper.printTextElement(secondBlockElement);

    }

}
