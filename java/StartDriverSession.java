import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class StartDriverSession {

    public static AppiumDriver initializeDriver(String platFormName) throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        String androidAppURL = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator +
                File.separator + "resources" + File.separator + "ApiDemos-debug.apk";

        String iosAppURL = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator +
                File.separator + "resources" + File.separator + "UIKitCatalog-iphonesimulator.app";

        URL url = new URL("http://localhost:4723/wd/hub");


        switch (platFormName) {
            case "AndroidEmulator":
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel3");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");

                //to launch emulator automatically
                caps.setCapability("avd", "Pixel_3");
                caps.setCapability("avdLaunchTimeout", 180000);

                 caps.setCapability(MobileCapabilityType.APP,androidAppURL);

                //In case of we don't want to install an app and open an existing app present in mobile
                //We use app package and app activity
                caps.setCapability("appPackage", "io.appium.android.apis");
                caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

                return new AndroidDriver(url, caps);


            case "AndroidRealDevice":
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "OnePlus");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                caps.setCapability(MobileCapabilityType.UDID, "dfbb274d");

                caps.setCapability("appPackage", "io.appium.android.apis");
                caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

                return new AndroidDriver(url,caps);

            case "IosSimulator":
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone11");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                caps.setCapability(MobileCapabilityType.UDID, "6B2C3067-5E47-43F8-9B53-B28AFB0C1C21");

                //caps.setCapability(MobileCapabilityType.APP,iosAppURL);

                //to launch simulator automatically
                caps.setCapability("simulatorStartupTimeout", 180000);

                caps.setCapability("bundleId", "com.example.apple-samplecode.UICatalog");

                return new IOSDriver(url,caps);
            case "IosRealDevice":
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone11");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                caps.setCapability(MobileCapabilityType.UDID, "6B2C3067-5E47-43F8-9B53-B28AFB0C1C21");

                //extra capabilities for real device ios
                caps.setCapability("xcodeOrgId", "849UP4BSN8");
                caps.setCapability("xcodeSigningId", "iPhone Developer");


                //caps.setCapability(MobileCapabilityType.APP,iosAppURL);
              //  caps.setCapability("bundleId", "com.example.apple-samplecode.UICatalog");
                caps.setCapability("bundleId", "com.example.apple-samplecode.UICatalog");

                return new IOSDriver(url,caps);

            default:
                throw new Exception("invalid platform");


        }
    }

}
