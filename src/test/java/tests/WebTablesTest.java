package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.util.List;

public class WebTablesTest extends SharedData {

    @Test
    public void testMethod(){


        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsMenu.click();

        WebElement webTables = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        webTables.click();

        List<WebElement> tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        int tableSize = 3;
        Assert.assertEquals(tableList.size(),tableSize);


        //identificam un element
        WebElement addElement= driver.findElement(By.id("addNewRecordButton"));
        addElement.click();

        WebElement firstnameElement= driver.findElement(By.id("firstName"));
        String firstnameValue="Test";
        firstnameElement.sendKeys(firstnameValue);

        WebElement lastnameElement= driver.findElement(By.id("lastName"));
        String lastnameValue="BOC";
        lastnameElement.sendKeys(lastnameValue);

        WebElement emailElement= driver.findElement(By.id("userEmail"));
        String emailValue=lastnameValue+"@yopmail.com";
        emailElement.sendKeys(emailValue);

        WebElement ageElement = driver.findElement(By.id("age"));
        String ageValue="22";
        ageElement.sendKeys(ageValue);

        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salaryValue="4444";
        salaryElement.sendKeys(salaryValue);

        WebElement departmentElement = driver.findElement(By.id("department"));
        String departmentValue = "IT";
        departmentElement.sendKeys(departmentValue);

        //FORCED CLICK ON ELEMENT

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebElement submitElement=driver.findElement(By.id("submit"));
        executor.executeScript("arguments[0].click();", submitElement);

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(),tableSize +1 );
        Assert.assertTrue(tableList.get(tableSize).getText().contains(firstnameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(lastnameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(emailValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(ageValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(salaryValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(departmentValue));


        //edit functionality

        WebElement editElement = driver.findElement(By.id("edit-record-4"));
        executor.executeScript("arguments[0].click();", editElement);

        WebElement editFirstNameElement= driver.findElement(By.id("firstName"));
        String editFirstNameValue="TETE";
        editFirstNameElement.clear();
        editFirstNameElement.sendKeys(editFirstNameValue);

        WebElement editLastNameElement= driver.findElement(By.id("lastName"));
        String editLastNameValue="UUUUUU";
        editLastNameElement.clear();
        editLastNameElement.sendKeys(editLastNameValue);

        WebElement editUserEmailElement= driver.findElement(By.id("userEmail"));
        String editUserEmailValue="UUUUUU@yopmail.com";
        editUserEmailElement.clear();
        editUserEmailElement.sendKeys(editUserEmailValue);

        WebElement editAgeElement= driver.findElement(By.id("age"));
        String editAgeValue="44";
        editAgeElement.clear();
        editAgeElement.sendKeys(editAgeValue);

        WebElement editSalaryElement= driver.findElement(By.id("salary"));
        String editSalaryValue="2222";
        editSalaryElement.clear();
        editSalaryElement.sendKeys(editSalaryValue);

        WebElement editDepartmentElement= driver.findElement(By.id("department"));
        String editDepartmentValue="MARKETING";
        editDepartmentElement.clear();
        editDepartmentElement.sendKeys(editDepartmentValue);

        WebElement editSubmitElement= driver.findElement(By.id("submit"));
        editSubmitElement.click();

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(),tableSize +1 );
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editFirstNameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editLastNameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editUserEmailValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editAgeValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editSalaryValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editDepartmentValue));

        //delete functionality

        WebElement deleteElement=driver.findElement(By.id("delete-record-4"));
        executor.executeScript("arguments[0].click();", deleteElement);

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(),tableSize );

        driver.quit();



    }
}
