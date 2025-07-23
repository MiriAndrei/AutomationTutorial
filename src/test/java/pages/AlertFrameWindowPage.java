package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertFrameWindowPage extends BasePage{



    public AlertFrameWindowPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = "//span[text()='Alerts']")
    private WebElement alertFormTable;
    @FindBy(xpath = "//span[text()='Frames']")
    private WebElement frameFormElement;

    public void interactWithAlertsSubMenu(){
        elementHelper.clickElement(alertFormTable);
        LoggerUtility.infoLog("The user clicks on alerts sub menu");
    }

    public void interactWithFramesSubMenu(){
        elementHelper.clickJSElement(frameFormElement);
    }
}
