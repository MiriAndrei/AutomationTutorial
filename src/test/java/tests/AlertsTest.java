package tests;

import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.AlertPage;
import pages.IndexPage;
import sharedData.SharedData;
import suite.Suite;

public class AlertsTest extends SharedData {

    @Test(groups = {Suite.REGRESSION_SUITE,Suite.SANITY_SUITE,Suite.ALERT_SUITE})

    public void WindowTestMethod() {

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        IndexPage indexPage = new IndexPage(getDriver());
        AlertPage alertPage = new AlertPage(getDriver());

        indexPage.interactOnAlertsFraneWindowMenu();
        alertFrameWindowPage.interactWithAlertsSubMenu();

        alertPage.dealAlertOk();
        alertPage.dealAlertTimer();
        alertPage.dealConfirmButton();
        alertPage.dealALertPrompt("Andrei");



    }
}
