package pages;

import helperMethods.ElementHelper;
import helperMethods.PageHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.List;

public class PracticeFormPage extends BasePage {


    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Practice Form']")
    private WebElement practiceFormTable;

    @FindBy(css = "input[placeholder='First Name']")
    private WebElement firstNameElement;

    @FindBy(css = "input[placeholder='Last Name']")
    private WebElement lastNameElement;

    @FindBy(css = "input[placeholder='name@example.com']")
    private WebElement emailElement;

    @FindBy(css = "input[placeholder='Mobile Number']")
    private WebElement mobileNumberElement;

    @FindBy(id = "subjectsInput")
    private WebElement subjectsElement;

    @FindBy(css = "div[id='genterWrapper'] label[class='custom-control-label']")
    private List<WebElement> genderElementList;

    @FindBy(css = "div[id='hobbiesWrapper'] label[class='custom-control-label']")
    private List<WebElement> hobbiesElementList;

    @FindBy(id = "uploadPicture")
    private WebElement uploadElement;

    @FindBy(id = "currentAddress")
    private WebElement currentAdress;

    @FindBy(id = "state")
    private WebElement stateElement;

    @FindBy(id = "react-select-3-input")
    private WebElement stateInputElement;

    @FindBy(id = "react-select-4-input")
    private WebElement cityInputElement;

    @FindBy(id = "submit")
    private WebElement submitElement;

    @FindBy(xpath = "//table//td[1]")
    List<WebElement> tableDescriptionList;

    @FindBy(xpath = "//table//td[2]")
    List<WebElement> tableValueList;

//    @FindBy(xpath = "//table//td[1]")
//    List<WebElement> tableDescriptionList;


    public void fillEntireForm(String firstNameValue, String lastNameValue, String emailValue, String mobileNumberValue,
                               List<String> subjectsValue, String genderValue, List<String> hobbiesValues,
                               String uploadValue, String currentAdressValue, String stateValue, String cityValue) {
        elementHelper.fillElement(firstNameElement, firstNameValue);
        elementHelper.fillElement(lastNameElement, lastNameValue);
        elementHelper.fillElement(emailElement, emailValue);
        elementHelper.fillElement(mobileNumberElement, mobileNumberValue);
        //ai o lista de string=uri si vrei sa iti transforme intr-un singur string   delimitat  cu , si spatiu
        String subjectsValueString = String.join(", ", subjectsValue);
        for (int index = 0; index < subjectsValue.size(); index++) {
            elementHelper.fillPressElement(subjectsElement, subjectsValue.get(index), Keys.ENTER);
        }
        pageHelper.scrollPage(0, 400);
        switch (genderValue) {
            case "Male":
                elementHelper.clickElement(genderElementList.get(0));
                break;
            case "Female":
                elementHelper.clickElement(genderElementList.get(1));
                break;
            case "Other":
                elementHelper.clickElement(genderElementList.get(2));
        }
        pageHelper.scrollPage(0, 400);

//        js.executeScript("window.scrollBy(0,400)", "");


        for (int index = 0; index < hobbiesElementList.size(); index++) {
            if (hobbiesValues.contains(hobbiesElementList.get(index).getText())) {
                elementHelper.clickElement(hobbiesElementList.get(index));
            }
        }

        File file = new File(uploadValue);
        elementHelper.fillElement(uploadElement, file.getAbsolutePath());
        elementHelper.fillElement(currentAdress, currentAdressValue);

        pageHelper.scrollPage(0, 400);

//        js.executeScript("window.scrollBy(0,400)", "");

        elementHelper.clickElement(stateElement);
        elementHelper.fillPressElement(stateInputElement, stateValue, Keys.ENTER);
        elementHelper.fillPressElement(cityInputElement, cityValue, Keys.ENTER);
        elementHelper.clickJSElement(submitElement);

//        elementHelper.validateElementEqualsText(tableDescriptionList.get(0),"Student Name");
//        elementHelper.validateElementContainsText(tableValueList.get(0), firstNameValue);
//        elementHelper.validateElementContainsText(tableValueList.get(0), lastNameValue);
//
//        elementHelper.validateElementEqualsText(tableDescriptionList.get(1),"Student Email");
//        elementHelper.validateElementEqualsText(tableValueList.get(1),emailValue);
//
//        elementHelper.validateElementEqualsText(tableDescriptionList.get(2),"Gender");
//        elementHelper.validateElementEqualsText(tableValueList.get(2),genderValue);
//
//        elementHelper.validateElementEqualsText(tableDescriptionList.get(3),"Mobile");
//        elementHelper.validateElementEqualsText(tableValueList.get(3),mobileNumberValue);
//
//        elementHelper.validateElementEqualsText(tableDescriptionList.get(5),"Subjects");
//        elementHelper.validateElementEqualsText(tableValueList.get(5),subjectsValueString);
//
//        elementHelper.validateElementEqualsText(tableDescriptionList.get(8),"Address");
//        elementHelper.validateElementEqualsText(tableValueList.get(8),currentAdressValue);
//
//        elementHelper.validateElementEqualsText(tableDescriptionList.get(9),"State and City");
//        elementHelper.validateElementEqualsText(tableValueList.get(9),stateValue+" "+cityValue);


    }

    public void validateFormValues(String firstNameValue, String lastNameValue, String emailValue, String genderValue, String mobileNumberValue,
                                   List<String> subjectsValueString, String currentAdressValue,
                                   String stateValue, String cityValue) {

        elementHelper.validateElementEqualsText(tableDescriptionList.get(0), "Student Name");
        elementHelper.validateElementContainsText(tableValueList.get(0), firstNameValue);
        elementHelper.validateElementContainsText(tableValueList.get(0), lastNameValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(1), "Student Email");
        elementHelper.validateElementEqualsText(tableValueList.get(1), emailValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(2), "Gender");
        elementHelper.validateElementEqualsText(tableValueList.get(2), genderValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(3), "Mobile");
        elementHelper.validateElementEqualsText(tableValueList.get(3), mobileNumberValue);

        String subjectsValue = String.join(", ", subjectsValueString);
        elementHelper.validateElementEqualsText(tableDescriptionList.get(5), "Subjects");
        elementHelper.validateElementEqualsText(tableValueList.get(5), subjectsValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(8), "Address");
        elementHelper.validateElementEqualsText(tableValueList.get(8), currentAdressValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(9), "State and City");
        elementHelper.validateElementEqualsText(tableValueList.get(9), stateValue + " " + cityValue);

    }


}


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
//      Assert.assertEquals(tableDescriptionList.get(4).getText(),"Date Of Birth","Date Of Birth is not displayed right");
//       Assert.assertEquals(tableDescriptionList.get(4).getText(),bir,"Gender is not displayed right");
//
//        Assert.assertEquals(tableDescriptionList.get(8).getText(),"Address", "Address is not displayed right");
//        Assert.assertEquals(tableValueList.get(8).getText(),currentAdressValue,"Address value is not displayed right");
//
//        Assert.assertEquals(tableDescriptionList.get(9).getText(),"State and City", "State and City are not displayed right");
//        Assert.assertEquals(tableValueList.get(9).getText(),stateValue+" "+cityValue, "State and City value wrong");
//    }




