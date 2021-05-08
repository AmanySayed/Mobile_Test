import com.google.common.collect.ImmutableMap;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Senario_Scroll {

    @Test
    public void TestRunner() throws MalformedURLException, InterruptedException {

        DesiredCapabilities Capabilities = new DesiredCapabilities();
        Capabilities.setCapability("version", "11.0");
        Capabilities.setCapability("deviceName", "Pixel_3a_API_30_x86");
        Capabilities.setCapability("platformName", "Android");
        Capabilities.setCapability("automationName", "Appium");
        Capabilities.setCapability("appPackage","io.appium.android.apis");
        Capabilities.setCapability("appActivity","io.appium.android.apis.ApiDemos");
        Capabilities.setCapability("orientation", "PORTRAIT");
        Capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
        //Capabilities.setCapability("app","E:\\ITI\\Automation Testing\\ApiDemos-debug.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),Capabilities);
        Thread.sleep(2000);
        AndroidElement element =  (AndroidElement) driver.findElementByAccessibilityId("Views");
        element.click();
        TouchAction mob_Action = new TouchAction(driver);
        Thread.sleep(2000);
        Dimension dim = driver.manage().window().getSize();
        double ymax = dim.getHeight();
        double ybottom = ymax*0.75 ;
        double ytop = ymax*0.25;


        while (driver.findElementsByAccessibilityId("Lists").size()==0)
        {
            mob_Action.press(PointOption.point(0,(int)ybottom))
                    .moveTo(PointOption.point(0,(int)ytop))
                    .release()
                    .perform();
        }
        driver.findElementByAccessibilityId("Lists").click();
        Thread.sleep(2000);
        driver.findElementByAccessibilityId("11. Multiple choice list").click();
        Thread.sleep(2000);
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.CheckedTextView[14]").click();
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        driver.activateApp("io.appium.android.apis");



    }

}
