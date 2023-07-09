import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class AndroidElements {

    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

       MobileElement myElement = (MobileElement) driver.findElementByAccessibilityId("Accessibility");
        System.out.println(myElement.getText());

         myElement = (MobileElement)driver.findElementByAccessibilityId("Accessibility");

        myElement = (MobileElement) driver.findElementById("android:id/text1");
        System.out.println(myElement.getText());

        myElement = (MobileElement) driver.findElementByClassName("android.widget.TextView");
        System.out.println(myElement.getText());

        myElement = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Accessibility\"]");
        System.out.println(myElement.getText());

       /* // findElementByName cannot be used by Android
        myElement = (MobileElement) driver.findElementByName("Accessibility");
        System.out.println(myElement.getText());

        //findElementByTagName cannot be used by Android depreciated
        myElement = (MobileElement) driver.findElementByTagName("Accessibility");
        System.out.println(myElement.getText());*/
    }
}
