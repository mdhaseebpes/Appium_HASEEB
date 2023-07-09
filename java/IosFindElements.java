import io.appium.java_client.*;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import java.lang.management.MonitorInfo;

public class IosFindElements {




    public static void main(String[] args) throws Exception {

        AppiumDriver driver = StartDriverSession.initializeDriver("IosSimulator");

        MobileElement element =(MobileElement) driver.findElementByAccessibilityId("Alert Views");
        System.out.println(element.getText());

        element=(MobileElement) driver.findElementsByClassName("XCUIElementTypeStaticText").get(2);
        System.out.println(element.getText());

        //native app
        String ele = ((FindsByIosNSPredicate)driver).findElementByIosNsPredicate("label == \"Alert Views\"").getText();
        System.out.println(ele);



        element=(MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Alert Views\"]");
        System.out.println(element.getText());

        element=(MobileElement) driver.findElementById("Alert Views");
        System.out.println(element.getText());

    }
}
