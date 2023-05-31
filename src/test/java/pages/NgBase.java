package pages;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.*;
import utilities.DeviceType;
import utilities.SetUpHelpers;

import java.net.MalformedURLException;
import java.time.Duration;

public class NgBase {
    protected AppiumDriver driver;
    int second = 30;
    DeviceType deviceType = DeviceType.ANDROID;

    String website = "https://www.stlouisfed.org/";

    @BeforeSuite
    public void setUp()  {
        try {
            SetUpHelpers helper = new SetUpHelpers();

            // IOS devices
            if (deviceType == DeviceType.IOS) {
                // Device 1: IOS simulator
                helper.startIOSDriver("16.4", "iPhone 14 Pro", "");

                // Device 2: IPhone
//                String UDID = "XXXXXXXX-XXXXXXXXXXXXXXXX";
//                helper.startIOSDriver("16.4.1", "iPhone", UDID);

                // Device 3: IPad
//                String UDID = "XXXXXXXX-XXXXXXXXXXXXXXXX";
//                helper.startIOSDriver("16.4", "iPad", UDID);

                // start IOS driver
                driver = helper.getIOSDriver();
            }
            // Android Device
            else if (deviceType == DeviceType.ANDROID) {
                // Device 1: Android Emulator - Google Pixel 3
                helper.startAndroidDriver("12", "emulator-5554","");

                // Device 2: Android Phone - don't use USB cable - connect over wifi network
//                helper.startAndroidDriver("9", "XXXXXXXXX", "192.168.X.X:5555");

                // Device 3: Android tablet
//                helper.startAndroidDriver("10", "XXXXXXXXXX", "");

                // start Android Driver
                driver = helper.getAndroidDriver();
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
            driver.navigate().to(website);
            System.out.println("Start driver success");

        } catch (MalformedURLException e) {
            System.out.println("Start driver fail");
            throw new RuntimeException(e);
        }
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
