package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebTablePage extends BasePage{

    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='rt-tr -even' or @class='rt-tr -odd']")
    private List<WebElement> tableList;

    @FindBy(id = "addNewRecordButton")
    private WebElement addElement;

    @FindBy(id = "firstName")
    private WebElement firstnameElement;

    @FindBy(id = "lastName")
    private WebElement lastnameElement;

    @FindBy(id = "userEmail")
    private WebElement emailElement;

    @FindBy(id = "age")
    private WebElement ageElement;

    @FindBy(id = "salary")
    private WebElement salaryElement;

    @FindBy(id = "department")
    private WebElement departmentElement;

    @FindBy(id = "submit")
    private WebElement submitElement;

    @FindBy(id = "edit-record-4")
    private WebElement editElement;

    @FindBy(id = "firstName")
    private WebElement editFirstNameElement;

    @FindBy(id = "lastName")
    private WebElement editLastNameElement;

    @FindBy(id = "userEmail")
    private WebElement editUserEmailElement;

    @FindBy(id = "age")
    private WebElement editAgeElement;

    @FindBy(id = "salary")
    private WebElement editSalaryElement;

    @FindBy(id = "department")
    private WebElement editDepartmentElement;

    @FindBy(id = "delete-record-4")
    WebElement deleteElement;

    public void addNewEntry(int tableSize,String firstnameValue, String lastnameValue,
                            String emailValue, String ageValue, String salaryValue, String departmentValue){
        elementHelper.validateListSize(tableList, tableSize);
        LoggerUtility.infoLog("The user validates that the table has "+tableSize+" rows");

        clickAddButton();
        fillFirstName(firstnameValue);
        fillLastName(lastnameValue);
        fillEmail(emailValue);
        fillAge(ageValue);
        fillSalary(salaryValue);
        fillDepartment(departmentValue);
        clickSubmit();


        int expectedTableSize = tableSize + 1;
        elementHelper.validateListSize(tableList, tableSize + 1);
        LoggerUtility.infoLog("The user validates that the table has "+expectedTableSize+" rows");
        elementHelper.validateElementContainsText(tableList.get(tableSize),firstnameValue);
        LoggerUtility.infoLog("The user validates that the table contains "+firstnameValue+" value");
        elementHelper.validateElementContainsText(tableList.get(tableSize),lastnameValue);
        LoggerUtility.infoLog("The user validates that the table contains "+lastnameValue+" value");
        elementHelper.validateElementContainsText(tableList.get(tableSize),emailValue);
        LoggerUtility.infoLog("The user validates that the table contains "+emailValue+" value");
        elementHelper.validateElementContainsText(tableList.get(tableSize),ageValue);
        LoggerUtility.infoLog("The user validates that the table contains "+ageValue+" value");
        elementHelper.validateElementContainsText(tableList.get(tableSize),salaryValue);
        LoggerUtility.infoLog("The user validates that the table contains "+salaryValue+" value");
        elementHelper.validateElementContainsText(tableList.get(tableSize),departmentValue);
        LoggerUtility.infoLog("The user validates that the table contains "+salaryValue+" value");

    }

    public void editEntry(String editFirstNameValue, String editLastNameValue,String editUserEmailValue,String editAgeValue,
                          String editSalaryValue,String editDepartmentValue){

        clickEdit();
        editFirstName(editFirstNameValue);
        editLastName(editLastNameValue);
        editUserEmail(editUserEmailValue);
        editAge(editAgeValue);
        editSalary(editSalaryValue);
        editDepartment(editDepartmentValue);
        clickSubmit();

    }

    public void clickAddButton (){
        elementHelper.clickJSElement(addElement);
        LoggerUtility.infoLog("The user clicks the add button");
    }

    public void fillFirstName(String firstnameValue){
        elementHelper.fillElement(firstnameElement, firstnameValue);
        LoggerUtility.infoLog("The user fills the first name with + "+firstnameValue);
    }

    public void fillLastName(String lastnameValue){
        elementHelper.fillElement(lastnameElement, lastnameValue);
        LoggerUtility.infoLog("The user fills the last name with + "+lastnameValue);
    }

    public void fillEmail(String emailValue){
        elementHelper.fillElement(emailElement, emailValue);
        LoggerUtility.infoLog("The user fills the email with + "+emailValue);
    }

    public void fillAge(String ageValue){
        elementHelper.fillElement(ageElement, ageValue);
        LoggerUtility.infoLog("The user fills the age with + "+ageValue);
    }

    public void fillSalary(String salaryValue){
        elementHelper.fillElement(salaryElement, salaryValue);
        LoggerUtility.infoLog("The user fills the salary with + "+salaryValue);
    }

    public void fillDepartment(String departmentValue){
        elementHelper.fillElement(departmentElement, departmentValue);
        LoggerUtility.infoLog("The user fills the department with + "+departmentValue);
    }

    public void clickSubmit(){
        elementHelper.clickElement(submitElement);
        LoggerUtility.infoLog("The user clicks the submit button");
    }

    public void editFirstName(String editFirstNameValue){
        elementHelper.editElement(editLastNameElement, editFirstNameValue);
        LoggerUtility.infoLog("The user edits first name with + "+editFirstNameValue);
    }

    public void editLastName(String editLastNameValue){
        elementHelper.editElement(editLastNameElement, editLastNameValue);
        LoggerUtility.infoLog("The user edits last name with + "+editLastNameValue);
    }

    public void editUserEmail(String editUserEmailValue){
        elementHelper.editElement(editUserEmailElement, editUserEmailValue);
        LoggerUtility.infoLog("The user edits email with + "+editUserEmailValue);
    }

    public void editAge(String editAgeValue){
        elementHelper.editElement(editAgeElement, editAgeValue);
        LoggerUtility.infoLog("The user edits age with + "+editAgeValue);
    }

    public void editSalary(String editSalaryValue){
        elementHelper.editElement(editSalaryElement, editSalaryValue);
        LoggerUtility.infoLog("The user edits salary with + "+editSalaryValue);
    }

    public void editDepartment(String editDepartmentValue){
        elementHelper.editElement(editDepartmentElement, editDepartmentValue);
        LoggerUtility.infoLog("The user edits department with + "+editDepartmentValue);
    }

    public void clickEdit(){
        elementHelper.clickJSElement(editElement);
        LoggerUtility.infoLog("The user clicks on edit button");
    }

    public void deleteElement(){
        elementHelper.clickJSElement(deleteElement);
        LoggerUtility.infoLog("The user deleted element");
    }

    public void deleteNewEntry(int tableSize){
        deleteElement();
        elementHelper.validateListSize(tableList, tableSize);
    }


}
