import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class FetchElementAttributes {

    @iOSXCUITFindBy(accessibility="Activity Indicators")
    private static MobileElement element;

    @AndroidFindBy(accessibility = "Accessibility")
    private static MobileElement element1;

   public FetchElementAttributes(AppiumDriver driver){
       PageFactory.initElements(new AppiumFieldDecorator(driver) , this);
   }

    public static void main(String[] args) throws Exception {

        AppiumDriver driver = StartDriverSession.initializeDriver("AndroidEmulator");

        FetchElementAttributes fetch = new FetchElementAttributes(driver);
        System.out.println("value :" + element.getAttribute("value"));
        System.out.println("label :" + element.getAttribute("label"));
        System.out.println("enabled :" + element.getAttribute("enabled"));
        System.out.println("visible :" + element.getAttribute("visible"));
        System.out.println("accessible :" + element.getAttribute("accessible"));


        System.out.println("selected :" + element.isSelected());
        System.out.println("enabled :" + element.isEnabled());
        System.out.println("displayed :" + element.isDisplayed());

        AppiumDriver driver1 = StartDriverSession.initializeDriver("AndroidEmulator");

        FetchElementAttributes fetch1 = new FetchElementAttributes(driver1);
        System.out.println("text :" + element1.getAttribute("text"));
        System.out.println("checked :" + element1.getAttribute("checked"));
        System.out.println("enabled :" + element1.getAttribute("enabled"));
        System.out.println("selected :" + element1.getAttribute("selected"));
        System.out.println("displayed :" + element1.getAttribute("displayed"));

        System.out.println("selected :" + element1.isSelected());
        System.out.println("enabled :" + element1.isEnabled());
        System.out.println("displayed :" + element1.isDisplayed());






    }
}
