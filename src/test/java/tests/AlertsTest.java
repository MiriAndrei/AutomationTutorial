package tests;

import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.AlertPage;
import pages.IndexPage;
import sharedData.SharedData;

public class AlertsTest extends SharedData {

    @Test

    public void WindowTestMethod() {

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(driver);
        IndexPage indexPage = new IndexPage(driver);
        AlertPage alertPage = new AlertPage(driver);

        indexPage.interactOnAlertsFraneWindowMenu();
        alertFrameWindowPage.interactWithAlertsSubMenu();

        alertPage.dealAlertOk();
        alertPage.dealAlertTimer();
        alertPage.dealConfirmButton();
        alertPage.dealALertPrompt("Andrei");

    }
}
