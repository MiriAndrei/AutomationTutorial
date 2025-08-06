package tests;

import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.FramesPage;
import pages.IndexPage;
import sharedData.SharedData;
import suite.Suite;

public class FrameTest extends SharedData {


    @Test(groups = {Suite.FRAME_SUITE , Suite.SANITY_SUITE})

    public void WindowTestMethod() {

        IndexPage indexPage = new IndexPage(getDriver());
        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        FramesPage framesPage= new FramesPage(getDriver());

        indexPage.interactOnAlertsFraneWindowMenu();
        alertFrameWindowPage.interactWithFramesSubMenu();

        framesPage.dealWithBigIframe();
        framesPage.dealWithLittleIframe();

    }

}
