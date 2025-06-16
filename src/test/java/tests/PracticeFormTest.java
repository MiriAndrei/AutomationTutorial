package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest {
    public WebDriver driver;

    @Test

    public void testMethod() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");



        WebElement practiceForm = driver.findElement(By.xpath("//h5[text()='Forms']"));
        practiceForm.click();

        WebElement practiceFormTable = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        practiceFormTable.click();

        //WAIT implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //tag [input='atribut'](cautare pe site CSS)
        //input[placeholder='First Name']

        WebElement firstNameElement=driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        String firstNameValue="Andrei";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement=driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
        String lastNameValue="Miri";
        lastNameElement.sendKeys(lastNameValue);

        WebElement emailElement=driver.findElement(By.cssSelector("input[placeholder='name@example.com']"));
        String emailValue="test@test.com";
        emailElement.sendKeys(emailValue);

        WebElement mobileNumberElement=driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String mobileNumberValue="0782332222";
        mobileNumberElement.sendKeys(mobileNumberValue);

        WebElement subjectsElement=driver.findElement(By.id("subjectsInput"));
        List<String> subjectsValue= Arrays.asList("Accounting","Maths");
        //String subjectsValueString = String.join(",", subjectsValue);
        for(int index=0;index<subjectsValue.size();index++){
            subjectsElement.sendKeys(subjectsValue.get(index));
            subjectsElement.sendKeys(Keys.ENTER);
        }
        //ai o lista de string=uri si vrei sa iti transforme intr-un singur string   delimitat  cu , si spatiu


        String genderValue="Other";
        List<WebElement> genderElementList=driver.findElements(By.cssSelector("div[id='genterWrapper'] label[class='custom-control-label']"));
        switch (genderValue){
            case "Male":
                genderElementList.get(0).click();
                break;
            case "Female":
                genderElementList.get(1).click();
                break;
            case "Other":
                genderElementList.get(2).click();
        }

        js.executeScript("window.scrollBy(0,400)", "");


        List<WebElement> hobbiesElementList=driver.findElements(By.cssSelector("div[id='hobbiesWrapper'] label[class='custom-control-label']"));
        for (int index=0; index< hobbiesElementList.size();index++){
            hobbiesElementList.get(index).click();
        }



//        js.executeScript("window.scrollBy(0,400)", "");

        WebElement uploadElement= driver.findElement(By.id("uploadPicture"));
        String uploadValue="src/test/resources/Screenshot 2025-05-28 at 7.42.31 PM.png";
        File file = new File(uploadValue);
        uploadElement.sendKeys(file.getAbsolutePath());

        WebElement currentAdress= driver.findElement(By.id("currentAddress"));
        String currentAdressValue="Str Principala nr.1";
        currentAdress.sendKeys(currentAdressValue);

        js.executeScript("window.scrollBy(0,400)", "");

        WebElement stateElement=driver.findElement(By.id("state"));
        stateElement.click();

        WebElement stateInputElement=driver.findElement(By.id("react-select-3-input"));
        String stateValue="NCR";
        stateInputElement.sendKeys(stateValue);
        stateInputElement.sendKeys(Keys.ENTER);

        WebElement cityInputElement=driver.findElement(By.id("react-select-4-input"));
        String cityValue="Delhi";
        cityInputElement.sendKeys(cityValue);
        cityInputElement.sendKeys(Keys.ENTER);


        WebElement submitElement=driver.findElement(By.id("submit"));
        executor.executeScript("arguments[0].click();", submitElement);

        //WAIT explicit
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table//td[1]")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table//td[2]")));


        //VALIDARI

        List<WebElement> tableDescriptionList=driver.findElements(By.xpath("//table//td[1]"));
        List<WebElement> tableValueList=driver.findElements(By.xpath("//table//td[2]"));

        Assert.assertEquals(tableDescriptionList.get(0).getText(),"Student Name","Student Name text is not display right in the table");
        Assert.assertTrue(tableValueList.get(0).getText().contains(firstNameValue));
        Assert.assertTrue(tableValueList.get(0).getText().contains(lastNameValue));

        Assert.assertEquals(tableDescriptionList.get(1).getText(),"Student Email","Student emaul is not displayed right");
        Assert.assertEquals(tableValueList.get(1).getText(),emailValue,"Student emaul is not displayed right");

        Assert.assertEquals(tableDescriptionList.get(2).getText(),"Gender","Gender is not displayed right");
        Assert.assertEquals(tableValueList.get(2).getText(),genderValue,"Gender is not displayed right");

        Assert.assertEquals(tableDescriptionList.get(3).getText(),"Mobile","Mobile is not displayed right");
        Assert.assertEquals(tableValueList.get(3).getText(),mobileNumberValue,"Mobile is not displayed right");

//        Assert.assertEquals(tableDescriptionList.get(5).getText(),"Subjects", "Subjects are not displayed right");
//        Assert.assertEquals(tableValueList.get(5).getText(),subjectsValueString);

//        Assert.assertEquals(tableDescriptionList.get(4).getText(),"Date Of Birth","Date Of Birth is not displayed right");
//        Assert.assertEquals(tableDescriptionList.get(4).getText(),bir,"Gender is not displayed right");











        driver.quit();
    }
}