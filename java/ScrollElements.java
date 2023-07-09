import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class ScrollElements {

    static AppiumDriver driver;

    public static void main(String[] args) throws Exception {
        driver = StartDriverSession.initializeDriver("AndroidRealDevice");
    }

    public void androidScroll() {
        By graphics = By.xpath("");
        By alpha = By.xpath("");
        By xferModes = By.xpath("");

        driver.findElement(graphics).click();
        scrollToElement(alpha,"up");

        driver.findElement(alpha).isDisplayed();

        scrollToElement(xferModes,"down");

        driver.findElement(xferModes).isDisplayed();


    }

    //methods will work for IOS as well
    public static void scrollToElement(By e, String direction){
        for(int i=0;i<3;i++){
            if(isDisplayed(e)){
                break;
            }else{
                if(direction.equalsIgnoreCase("up")){
                    scrollUsingTouchAction("up");
                }else{
                    scrollUsingTouchAction("down");
                }
            }
        }
    }

    public static boolean isDisplayed(final By e){
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        try {
            WebDriverWait wait = new WebDriverWait(driver,2);
            return wait.until(new ExpectedCondition<Boolean>() {

                public Boolean apply( WebDriver driver) {
                    if(driver.findElement(e).isDisplayed()) {
                        return true;
                    }
                    return  false;
                }
            });

        }catch (Exception ex){
            return false;
        }
    }



    public static void scrollUsingTouchAction(String direction) {

        Dimension dim = driver.manage().window().getSize();
        int x = dim.getWidth() / 2;
        int startY = 0;
        int endY = 0;

        switch (direction) {
            case "up":
                startY = (int) (dim.getHeight() * 0.8);
                endY = (int) (dim.getHeight() * 0.2);
                break;
            case "down":
                startY = (int) (dim.getHeight() * 0.2);
                endY = (int) (dim.getHeight() * 0.8);
                break;

        }

        TouchAction touch = new TouchAction(driver);
        touch.press(PointOption.point(x, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).
                moveTo(PointOption.point(x, endY)).release().perform();
    }

    public  MobileElement scrollToElement() {
        return (io.appium.java_client.MobileElement) ((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector()" + ".scrollable(true)).scrollIntoView("
                        + "new UiSelector().description(\"test-Price\"));");
    }


    public void iOSScrollToElement() {
        RemoteWebElement element = (RemoteWebElement)driver.findElement(By.name("test-ADD TO CART"));
        String elementID = element.getId();
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("element", elementID);
//	  scrollObject.put("direction", "down");
//	  scrollObject.put("predicateString", "label == 'ADD TO CART'");
//	  scrollObject.put("name", "test-ADD TO CART");
        scrollObject.put("toVisible", "sdfnjksdnfkld");
        driver.executeScript("mobile:scroll", scrollObject);
    }
}
