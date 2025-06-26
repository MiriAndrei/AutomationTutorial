package tests;

import helperMethods.ElementHelper;
import helperMethods.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class FrameTest extends SharedData {


        @Test

        public void WindowTestMethod() {

            PageHelper pageHelper = new PageHelper(driver);
            ElementHelper elementHelper = new ElementHelper(driver);

            WebElement alertForm = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
            elementHelper.clickJSElement(alertForm);

            WebElement frameFormElement = driver.findElement(By.xpath("//span[text()='Frames']"));
            elementHelper.clickJSElement(frameFormElement);

            //driver.switchTo().frame("frame1");

            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame1']")));

            WebElement firstBlockElement = driver.findElement(By.id("sampleHeading"));
            System.out.println(firstBlockElement.getText());

            driver.switchTo().parentFrame();

            driver.switchTo().frame("frame2");
            WebElement secondBlockElement = driver.findElement(By.id("sampleHeading"));
            System.out.println();
            System.out.println(secondBlockElement.getText());

        }

}
