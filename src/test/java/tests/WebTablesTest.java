package tests;

import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.IndexPage;
import pages.WebTablePage;
import sharedData.SharedData;
import suite.Suite;

public class WebTablesTest extends SharedData {

    @Test(groups = {Suite.REGRESSION_SUITE,Suite.WINDOW_SUITE})
    public void testMethod() {

        IndexPage indexPage = new IndexPage(getDriver());
        ElementsPage elementsPage = new ElementsPage(getDriver());
        WebTablePage webTablePage = new WebTablePage(getDriver());

        indexPage.interactWithElementsMenu();
        elementsPage.interactWithWebTablesMenu();

        int tableSize = 3;
        String firstnameValue = "Test";
        String lastnameValue = "BOC";
        String emailValue = lastnameValue + "@yopmail.com";
        String ageValue = "22";
        String salaryValue = "4444";
        String departmentValue = "IT";

        String editFirstNameValue = "TETE";
        String editLastNameValue = "UUUUUU";
        String editUserEmailValue = "UUUUUU@yopmail.com";
        String editAgeValue = "44";
        String editSalaryValue = "2222";
        String editDepartmentValue = "MARKETING";

        webTablePage.addNewEntry(tableSize,firstnameValue,lastnameValue, emailValue,ageValue, salaryValue, departmentValue );
        webTablePage.editEntry(editFirstNameValue, editLastNameValue, editUserEmailValue, editAgeValue, editSalaryValue, editDepartmentValue);
        webTablePage.deleteNewEntry(3);
    }
}
