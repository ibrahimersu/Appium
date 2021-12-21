package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileChromeTest {

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "10");
        caps.setCapability("deviceName", "Pixel 3");
        caps.setCapability("browserName", BrowserType.CHROME);

        URL url = new URL("http://localhost:4723/wd/hub");
        WebDriver driver = new RemoteWebDriver(url, caps);

        driver.get("http://qa1.vytrack.com");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        Thread.sleep(3000);

        driver.quit();
    }
}
