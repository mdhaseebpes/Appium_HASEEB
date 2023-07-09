import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;

public class AndroidUiAutomator {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = StartDriverSession.initializeDriver("AndroidRealDevice");

        MobileElement myElement = (MobileElement) ((FindsByAndroidUIAutomator) driver)
                .findElementByAndroidUIAutomator("new UiSelector().text(\"Accessibility\")");
        System.out.println(myElement.getText());

        myElement = (MobileElement) ((FindsByAndroidUIAutomator) driver)
                .findElementsByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\")").get(2);
        System.out.println(myElement.getText());

        myElement = (MobileElement) ((FindsByAndroidUIAutomator) driver)
                .findElementByAndroidUIAutomator("new UiSelector().description(\"Accessibility\")");
        System.out.println(myElement.getText());

        myElement = (MobileElement) ((FindsByAndroidUIAutomator) driver)
                .findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"android:id/text1\")").get(1);
        System.out.println(myElement.getText());

        myElement = (MobileElement)((FindsByAndroidUIAutomator)driver).findElementByAndroidUIAutomator
                ("new UiSelector().text(\"Accessibility\")");
        System.out.println(myElement);

    }
}
