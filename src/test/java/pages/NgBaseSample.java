package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class NgBaseSample {

    public ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    String website = "https://philadelphiafed.org";
    AppiumDriverLocalService service;

    public void setDriverTest(AppiumDriver driver) {
        this.driver.set(driver);
    }

    public AppiumDriver getDriverTest() {
        return this.driver.get();
    }

    @BeforeTest
    @Parameters({"deviceName","platformVersion","portNumber"})
    public void initiateDriver(String deviceName, String platformVersion, String portNumber) throws MalformedURLException, InterruptedException {
        startAppiumServer(portNumber);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("browserName", "Chrome");

        setDriverTest(new AndroidDriver(new URL("http://127.0.0.1:" + portNumber), capabilities));

        getDriverTest().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        getDriverTest().navigate().to(website);
    }

    @AfterTest
    public void closeDriver(){
        service.close();
        getDriverTest().quit();
        driver.remove();
    }
    public void startAppiumServer(String portNumber) {
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withAppiumJS(new File("/opt/homebrew/lib/node_modules/appium/build/lib/main.js"));
        builder.usingDriverExecutable(new File("/opt/homebrew/bin/node"));
        builder.usingPort(Integer.parseInt(portNumber));
        builder.withArgument(GeneralServerFlag.LOCAL_TIMEZONE);
        builder.withLogFile(new File("Appiumlog.txt"));
        builder.withIPAddress("127.0.0.1");
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
        System.out.println("service has been started with port number: " + portNumber);
    }
}
