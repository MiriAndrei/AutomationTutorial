package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage{


    public AlertPage(WebDriver driver) {
       super(driver);
    }

    @FindBy(id = "alertButton")
    private WebElement alertOkButtonElement;
    @FindBy(id = "timerAlertButton")
    private WebElement alertsWaitButtonElement;
    @FindBy(id = "confirmButton")
    private WebElement alertOkCancelElement;
    @FindBy(id = "promtButton")
    private WebElement alertPromtElement;



    public void dealAlertOk(){
        elementHelper.clickElement(alertOkButtonElement);
        LoggerUtility.infoLog("The user clicks on alert ok button");
        alertHelper.acceptAlert();
        LoggerUtility.infoLog("User accepts alert");
    }

    public void dealAlertTimer(){
        elementHelper.clickElement(alertsWaitButtonElement);
        LoggerUtility.infoLog("The user clicks on alert timer button");
        alertHelper.acceptAlert();
        LoggerUtility.infoLog("The user accepts on alert timer button");

    }

    public void dealConfirmButton(){
        elementHelper.clickElement(alertOkCancelElement);
        LoggerUtility.infoLog("The user clicks on confirm button");
        alertHelper.dismissAlert();
        LoggerUtility.infoLog("The user cancel the alert");

    }

    public void dealALertPrompt(String value){
        elementHelper.clickElement(alertPromtElement);
        LoggerUtility.infoLog("The user clicks on alert prompt button");
        alertHelper.fillAlert(value);
        LoggerUtility.infoLog("The user fills the alert pop-up with the value: "+ value);
    }
}
