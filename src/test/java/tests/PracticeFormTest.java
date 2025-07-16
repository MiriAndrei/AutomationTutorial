package tests;

import helperMethods.ElementHelper;
import helperMethods.PageHelper;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.IndexPage;
import pages.PracticeFormPage;
import sharedData.SharedData;

import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test

    public void testMethod() {

        PageHelper pageHelper = new PageHelper(driver);
        ElementHelper elementHelper = new ElementHelper(driver);
        pageHelper.scrollPage(0, 400);

        IndexPage indexPage = new IndexPage(driver);
        indexPage.interactWithFormsMenu();

        FormsPage formsPage = new FormsPage(driver);
        formsPage.interactWithPracticeFormSubmenu();

        String firstNameValue = "Andrei";
        String lastNameValue = "Miri";
        String emailValue = "test@test.com";
        String mobileNumberValue = "0782332222";
        List<String> subjectsValue = Arrays.asList("Accounting", "Maths");
        //ai o lista de string=uri si vrei sa iti transforme intr-un singur string   delimitat  cu , si spatiu
        String genderValue = "Male";
        List<String> hobbiesValues = Arrays.asList("Sports", "Reading");
        String uploadValue = "src/test/resources/Screenshot 2025-05-28 at 7.42.31 PM.png";
        String currentAdressValue = "Str Principala nr.1";
        String stateValue = "NCR";
        String cityValue = "Delhi";

        PracticeFormPage practiceFormPage = new PracticeFormPage(driver);
        practiceFormPage.fillEntireForm(firstNameValue, lastNameValue, emailValue, mobileNumberValue, subjectsValue,
                genderValue,hobbiesValues, uploadValue, currentAdressValue, stateValue, cityValue);

        practiceFormPage.validateFormValues(firstNameValue,lastNameValue,emailValue,genderValue,mobileNumberValue,subjectsValue,
                currentAdressValue,stateValue,cityValue);

    }
}
//        WebElement submitElement=driver.findElement(By.id("submit"));
//        elementHelper.clickJSElement(submitElement);
//
//        //WAIT explicit
//        //VALIDARI
//
//        List<WebElement> tableDescriptionList=driver.findElements(By.xpath("//table//td[1]"));
//        List<WebElement> tableValueList=driver.findElements(By.xpath("//table//td[2]"));
//
//        Assert.assertEquals(tableDescriptionList.get(0).getText(),"Student Name","Student Name text is not display right in the table");
//        Assert.assertTrue(tableValueList.get(0).getText().contains(firstNameValue));
//        Assert.assertTrue(tableValueList.get(0).getText().contains(lastNameValue));
//
//        Assert.assertEquals(tableDescriptionList.get(1).getText(),"Student Email","Student email is not displayed right");
//        Assert.assertEquals(tableValueList.get(1).getText(),emailValue,"Student email is not displayed right");
//
//        Assert.assertEquals(tableDescriptionList.get(2).getText(),"Gender","Gender is not displayed right");
//        Assert.assertEquals(tableValueList.get(2).getText(),genderValue,"Gender is not displayed right");
//
//        Assert.assertEquals(tableDescriptionList.get(3).getText(),"Mobile","Mobile is not displayed right");
//        Assert.assertEquals(tableValueList.get(3).getText(),mobileNumberValue,"Mobile is not displayed right");
//
//        Assert.assertEquals(tableDescriptionList.get(5).getText(),"Subjects", "Subjects are not displayed right");
//        Assert.assertEquals(tableValueList.get(5).getText(),subjectsValueString);
//
//        Assert.assertEquals(tableDescriptionList.get(4).getText(),"Date Of Birth","Date Of Birth is not displayed right");
//      Assert.assertEquals(tableDescriptionList.get(4).getText(),bir,"Gender is not displayed right");
//
//        Assert.assertEquals(tableDescriptionList.get(8).getText(),"Address", "Address is not displayed right");
//        Assert.assertEquals(tableValueList.get(8).getText(),currentAdressValue,"Address value is not displayed right");
//
//        Assert.assertEquals(tableDescriptionList.get(9).getText(),"State and City", "State and City are not displayed right");
//        Assert.assertEquals(tableValueList.get(9).getText(),stateValue+" "+cityValue, "State and City value wrong");
//    }


