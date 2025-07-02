package hook;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Hooks {

    @Before
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Android Device");
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setApp(System.getProperty("user.dir") + "/apps/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");

        // Tambahkan package & activity jika perlu
        options.setAppPackage("com.swaglabsmobileapp");
        options.setAppActivity("com.swaglabsmobileapp.SplashActivity");
        options.setAutoGrantPermissions(true);

        Base.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        Base.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        if (Base.driver != null) {
            Base.driver.quit();
        }
    }
}