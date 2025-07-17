package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertFrameWindowPage extends BasePage{



    public AlertFrameWindowPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = "//span[text()='Alerts']")
    public WebElement alertFormTable;
    @FindBy(xpath = "//span[text()='Frames']")
    public WebElement frameFormElement;

    public void interactWithAlertsSubMenu(){
        elementHelper.clickElement(alertFormTable);
    }

    public void interactWithFramesSubMenu(){
        elementHelper.clickJSElement(frameFormElement);
    }
}
