package pages;

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

//    public void addNewEntry(int tableList,String f ){
//
//    }
//
//    public void




}
