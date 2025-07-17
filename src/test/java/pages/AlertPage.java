package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage{


    public AlertPage(WebDriver driver) {
       super(driver);
    }

    @FindBy(id = "alertButton")
    public WebElement alertOkButtonElement;
    @FindBy(id = "timerAlertButton")
    public WebElement alertsWaitButtonElement;
    @FindBy(id = "confirmButton")
    public WebElement alertOkCancelElement;
    @FindBy(id = "promtButton")
    public WebElement alertPromtElement;



    public void dealAlertOk(){
        elementHelper.clickElement(alertOkButtonElement);
        alertHelper.acceptAlert();
    }

    public void dealAlertTimer(){
        elementHelper.clickElement(alertsWaitButtonElement);
        alertHelper.acceptAlert();
    }

    public void dealConfirmButton(){
        elementHelper.clickElement(alertOkCancelElement);
        alertHelper.dismissAlert();
    }

    public void dealALertPrompt(String value){
        elementHelper.clickElement(alertPromtElement);
        alertHelper.fillAlert(value);
    }
}
