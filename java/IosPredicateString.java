import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByIosNSPredicate;
import io.appium.java_client.MobileElement;

public class IosPredicateString {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = StartDriverSession
                .initializeDriver("IosSimulator");

        MobileElement myElement = (MobileElement) ((FindsByIosNSPredicate) driver)
                .findElementByIosNsPredicate("label CONTAINS \"Activity Indicators\"");
        System.out.println(myElement.getText());

       myElement= (MobileElement) ((FindsByIosNSPredicate)driver).findElementByIosNsPredicate("name == \"Alert View\" OR name ==\"Activity Indicators\"");
        System.out.println(myElement.getText());

        myElement= (MobileElement) ((FindsByIosNSPredicate)driver).findElementsByIosNsPredicate("name == \"Alert View\" OR name ==\"Activity Indicators\"").get(0);
        System.out.println(myElement.getText());

        myElement = (MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Activity Indicators\"]");
        System.out.println(myElement.getText());

     MobileElement ele1 =   (MobileElement) ((FindsByIosNSPredicate)driver).findElementByIosNsPredicate("label==''");


    }

}
