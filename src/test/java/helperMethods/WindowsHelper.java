package helperMethods;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class WindowsHelper {

    private WebDriver driver;

    public WindowsHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToWindow(int index){
        List<String> windowList= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(index));
    }

}
