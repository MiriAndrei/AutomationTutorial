package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends BasePage {


    public IndexPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    private WebElement alertForm;

    @FindBy(xpath = "//h5[text()='Forms']")
    private WebElement practiceForm;

    public void interactOnAlertsFraneWindowMenu(){
        elementHelper.clickJSElement(alertForm);
        LoggerUtility.infoLog("The user clicks on alert window frame menu");
    }

    public void  interactWithFormsMenu(){
        elementHelper.clickElement(practiceForm);
    }
}
