package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class EtsyTest {
    AppiumDriver<MobileElement> driver;

    @BeforeEach
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        //we can specify capability name with MobileCapabilityType class
        //we also have AndroidMobileCapabilityType that is used to specify Android specific capabilities
        caps.setCapability("deviceName", "Pixel 3");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "10");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("app", "https://cybertek-appium.s3.amazonaws.com/etsy.apk");
        URL url = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(url, caps);
    }

    @Test
    public void test1() {
        
    }

    @AfterEach
    public void teardown() {
        driver.closeApp();
        driver = null;
    }

}
