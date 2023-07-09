import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByIosNSPredicate;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DifferentWaysOfDefiningElement {

    @AndroidFindBy(xpath = "//*[@text=\"Alert Views\"]")
    @iOSXCUITFindBy(accessibility="Alert Views")
    private static MobileElement myElement;

    @FindBy(id = "Accessibility")
    private static MobileElement myElement1;

    public DifferentWaysOfDefiningElement(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public static void main(String[] args) throws Exception {

       AppiumDriver driver = StartDriverSession.initializeDriver("IosSimulator");

        DifferentWaysOfDefiningElement dw = new DifferentWaysOfDefiningElement(driver);
        System.out.println(myElement.getText());


       // System.out.println(myElement1.getText());

        //native app
        String ele = ((FindsByIosNSPredicate)driver).findElementByIosNsPredicate("label == \"Alert Views\"").getText();
        System.out.println(ele);

       MobileElement   element=(MobileElement) driver.findElementsByClassName("XCUIElementTypeStaticText").get(2);
        System.out.println(element.getText());

        WebElement element1= driver.findElementByClassName("XCUIElementTypeStaticText");
        System.out.println(element1.getText());

        By element2 = MobileBy.AccessibilityId("Alert Views");
        System.out.println(driver.findElement(element2).getText());

    }
}
