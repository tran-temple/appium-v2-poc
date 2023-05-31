package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SetUpHelpers {
    private AndroidDriver androidDriver;
    private IOSDriver iosDriver;

    /**
     * Returns the instance of the AppiumDriver.
     *
     * @return AndroidDriver instance
     */
    public AndroidDriver getAndroidDriver() {
        return androidDriver;
    }

    /**
     * Returns the instance of the AppiumDriver.
     *
     * @return IOSDriver instance
     */
    public IOSDriver getIOSDriver() {
        return iosDriver;
    }

    /**
     * This method creates the android driver
     *
     * @param platformVersion- version of android
     * @param deviceName-      name of the device
     * @param deviceId-      id of the device connect without cable only over wifi
     * @throws MalformedURLException Thrown to indicate that a malformed URL has occurred.
     */
    public void startAndroidDriver(String platformVersion, String deviceName, String deviceId) throws MalformedURLException {
        URL url = new URL("http://127.0.0.1:4723/");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability("automationName", "UiAutomator2");
        if (!deviceId.isEmpty()) {
            capabilities.setCapability("deviceId", deviceId);
        }
        // The below code comment to resolve Android version 13
        /*if (platformVersion.equals("13")){
            capabilities.setCapability("appPackage", "com.android.chrome");
            capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        } else{
            capabilities.setBrowserName(MobileBrowserType.CHROME);
        }*/
        capabilities.setCapability("browserName", "Chrome");
        androidDriver = new AndroidDriver(url, capabilities);
        /*if (platformVersion.equals("13")) {
            androidDriver.context("WEBVIEW_chrome");
        }*/
    }

    /**
     * This method creates the iOS driver
     *
     * @param platformVersion- version of ios
     * @param deviceName-      name of the device
     * @param UDID - unique identifier that Apple uses to associate a device to an iOS developer account so that developers can install and test their apps before releasing them.
     * @throws MalformedURLException Thrown to indicate that a malformed URL has occurred.
     */
    public void startIOSDriver(String platformVersion, String deviceName, String UDID) throws MalformedURLException {
        URL url = new URL("http://127.0.0.1:4723/");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "IOS");
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        if (!UDID.isEmpty()) {
            capabilities.setCapability("udid", UDID);
        }
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("browserName", "Safari");
        iosDriver = new IOSDriver(url, capabilities);
    }
}
