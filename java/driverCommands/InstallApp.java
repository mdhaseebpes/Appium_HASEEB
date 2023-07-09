package driverCommands;

import java.util.Map;

public class InstallApp {
    /*public void installApp() {
        try {
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                if (driver.isAppInstalled(driver.getCapabilities().getCapability("bundleId").toString())) {
                    driver.removeApp(driver.getCapabilities().getCapability("bundleId").toString());
                }
            }
        } catch (Exception ex) {
            logger.info("To un install app pass correct BundleID" + ex.getMessage());
        }

        Map<String, Object> params = new HashMap<>();
        String appName = "";
        if (AppiumDeviceManager.getDevice().getDeviceType().equalsIgnoreCase("local")) {
            appName = driver.getCapabilities().getCapability("app").toString();
        } else {
            appName = driver.getCapabilities().getCapability("cloudAppPath").toString();
        }

        params.put("instrument", "noinstrument");
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            params.put("resign", "true");
        }

        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            driver.installApp(appName);
        } else {
            if (AppiumDeviceManager.getDevice().getDeviceType().equalsIgnoreCase("local")) {
                params.put("app", appName);
                driver.executeScript("mobile:installApp", params);
            } else {
                params.put("file", appName);
                driver.executeScript("mobile:application:install", params);
            }
        }
    }*/
}

