package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowsPage extends BasePage{
    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id ="tabButton")
    private WebElement newTabElement;

    @FindBy(id = "windowButton")
    private WebElement newWindowElement;


    public void interactWithTab(){
        elementHelper.clickElement(newTabElement);
        LoggerUtility.infoLog("The user clicks on new tab button");
        tabHelper.switchToSpecificTab(1);
        LoggerUtility.infoLog("The user switches on the second tab");
        tabHelper.closeCurrentTab();
        LoggerUtility.infoLog("The user closes on the second tab");
        tabHelper.switchToSpecificTab(0);
        LoggerUtility.infoLog("The user switches back on the main tab");
    }

    public void interactWithWindow(){
        elementHelper.clickElement(newWindowElement);
        LoggerUtility.infoLog("The user clicks on new window button");
        tabHelper.switchToSpecificTab(1);
        LoggerUtility.infoLog("The user switches on the second window");
        tabHelper.closeCurrentTab();
        LoggerUtility.infoLog("The user closes on the second window");
        tabHelper.switchToSpecificTab(0);
        LoggerUtility.infoLog("The user switches back on the main window");
    }



}

