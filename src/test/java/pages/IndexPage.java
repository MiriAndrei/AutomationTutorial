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

    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement elementsMenu;

    public void interactOnAlertsFraneWindowMenu(){
        elementHelper.clickJSElement(alertForm);
        LoggerUtility.infoLog("The user clicks on alert window frame menu");
    }

    public void  interactWithFormsMenu(){
        pageHelper.scrollPage(0,400);
        elementHelper.clickElement(practiceForm);
        LoggerUtility.infoLog("The user clicks on forms menu");

    }



    public void interactWithElementsMenu(){
        pageHelper.scrollPage(0,400);
        elementHelper.waitVisibleElement(elementsMenu);
        elementHelper.clickElement(elementsMenu);
    }
}
