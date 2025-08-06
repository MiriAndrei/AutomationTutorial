package tests;

import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.IndexPage;
import pages.WindowsPage;
import sharedData.SharedData;
import suite.Suite;

public class WindowsTest extends SharedData {


    @Test(groups = {Suite.REGRESSION_SUITE,Suite.SANITY_SUITE, Suite.WINDOW_SUITE})

    public void testMethod() {
        IndexPage indexPage = new IndexPage(getDriver());
        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        WindowsPage windowsPage = new WindowsPage(getDriver());

        indexPage.interactOnAlertsFraneWindowMenu();
        alertFrameWindowPage.interactWithWindowsSubMenu();
        windowsPage.interactWithTab();
        windowsPage.interactWithWindow();

    }
}
