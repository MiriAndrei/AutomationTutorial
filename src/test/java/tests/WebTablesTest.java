package tests;

import helperMethods.ElementHelper;
import helperMethods.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IndexPage;
import sharedData.SharedData;

import java.util.List;

public class WebTablesTest extends SharedData {

    @Test
    public void testMethod() {

        ElementHelper elementHelper = new ElementHelper(driver);
        PageHelper pageHelper = new PageHelper(driver);
        IndexPage indexPage = new IndexPage(driver);

        pageHelper.scrollPage(0, 400);

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementHelper.clickElement(elementsMenu);

        WebElement webTables = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        elementHelper.clickElement(webTables);

        List<WebElement> tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        int tableSize = 3;
        elementHelper.validateListSize(tableList,tableSize);

        //identificam un element
        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        elementHelper.clickElement(addElement);

        WebElement firstnameElement = driver.findElement(By.id("firstName"));
        String firstnameValue = "Test";
        elementHelper.fillElement(firstnameElement, firstnameValue);

        WebElement lastnameElement = driver.findElement(By.id("lastName"));
        String lastnameValue = "BOC";
        elementHelper.fillElement(lastnameElement, lastnameValue);

        WebElement emailElement = driver.findElement(By.id("userEmail"));
        String emailValue = lastnameValue + "@yopmail.com";
        elementHelper.fillElement(emailElement, emailValue);

        WebElement ageElement = driver.findElement(By.id("age"));
        String ageValue = "22";
        elementHelper.fillElement(ageElement, ageValue);

        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salaryValue = "4444";
        elementHelper.fillElement(salaryElement, salaryValue);

        WebElement departmentElement = driver.findElement(By.id("department"));
        String departmentValue = "IT";
        elementHelper.fillElement(departmentElement, departmentValue);

        WebElement submitElement = driver.findElement(By.id("submit"));
        elementHelper.clickJSElement(submitElement);

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        elementHelper.validateListSize(tableList, tableSize + 1);


        elementHelper.validateElementContainsText(tableList.get(tableSize),firstnameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),lastnameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),emailValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),ageValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),salaryValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),departmentValue);

        //edit functionality

        WebElement editElement = driver.findElement(By.id("edit-record-4"));
        elementHelper.clickJSElement(editElement);

        WebElement editFirstNameElement = driver.findElement(By.id("firstName"));
        String editFirstNameValue = "TETE";
        elementHelper.editElement(editFirstNameElement, editFirstNameValue);

        WebElement editLastNameElement = driver.findElement(By.id("lastName"));
        String editLastNameValue = "UUUUUU";
        elementHelper.editElement(editLastNameElement, editLastNameValue);

        WebElement editUserEmailElement = driver.findElement(By.id("userEmail"));
        String editUserEmailValue = "UUUUUU@yopmail.com";
        elementHelper.editElement(editUserEmailElement, editUserEmailValue);

        WebElement editAgeElement = driver.findElement(By.id("age"));
        String editAgeValue = "44";
        elementHelper.editElement(editAgeElement, editAgeValue);

        WebElement editSalaryElement = driver.findElement(By.id("salary"));
        String editSalaryValue = "2222";
        elementHelper.editElement(editSalaryElement, editSalaryValue);

        WebElement editDepartmentElement = driver.findElement(By.id("department"));
        String editDepartmentValue = "MARKETING";
        elementHelper.editElement(editDepartmentElement, editDepartmentValue);

        WebElement editSubmitElement = driver.findElement(By.id("submit"));
        elementHelper.clickElement(editSubmitElement);

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        elementHelper.validateListSize(tableList,tableSize+1);

        elementHelper.validateElementContainsText(tableList.get(tableSize), editFirstNameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),editLastNameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),editUserEmailValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),editAgeValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),editSalaryValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),editDepartmentValue);

        //delete functionality

        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
        elementHelper.clickJSElement(deleteElement);

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        elementHelper.validateListSize(tableList, tableSize);

    }
}
