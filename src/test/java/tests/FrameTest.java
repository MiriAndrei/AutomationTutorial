package tests;

import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.FramesPage;
import pages.IndexPage;
import sharedData.SharedData;

public class FrameTest extends SharedData {


    @Test

    public void WindowTestMethod() {

        IndexPage indexPage = new IndexPage(driver);
        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(driver);
        FramesPage framesPage= new FramesPage(driver);

        indexPage.interactOnAlertsFraneWindowMenu();
        alertFrameWindowPage.interactWithFramesSubMenu();

        framesPage.dealWithBigIframe();
        framesPage.dealWithLittleIframe();

    }

}
