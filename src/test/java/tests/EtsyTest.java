package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class EtsyTest {
    AppiumDriver<MobileElement> driver;
    String email = "areatha@uspeakw.com";
    String password = "Cybertek2020";

    /**
     * user.email=areatha@uspeakw.com
     * user.password=Cybertek2020
     */

    @BeforeEach
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 3");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "10");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("app", "https://cybertek-appium.s3.amazonaws.com/etsy.apk");
        URL url = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(url, caps);
    }

    @Test
    public void test1() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.id("com.etsy.android:id/btn_link")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("com.etsy.android:id/edit_username")).sendKeys(email);
        driver.findElement(By.id("com.etsy.android:id/edit_password")).sendKeys(password);
        driver.findElement(By.id("com.etsy.android:id/button_signin")).click();
        Thread.sleep(2000);
        By textMsgsBy = By.id("com.etsy.android:id/message");
        List<MobileElement> elements = driver.findElements(textMsgsBy);
        elements.forEach(element -> System.out.println(element.getText()));
    }

    @AfterEach
    public void teardown() {
        driver.closeApp();
        driver = null;
    }

}
