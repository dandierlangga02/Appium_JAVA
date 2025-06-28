package stepdefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import io.appium.java_client.AppiumBy;

public class Login {
    private static AndroidDriver driver;

    @Given("the app is launched")
    public void the_app_is_launched() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Android Device");
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setApp(System.getProperty("user.dir") + "/apps/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");

        // Tambahan penting:
        options.setAppPackage("com.swaglabsmobileapp");
        options.setAppActivity("com.swaglabsmobileapp.SplashActivity");
        options.setAutoGrantPermissions(true); // otomatis klik izinkan

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("I enter username {string}")
    public void i_enter_username(String username) {
        WebElement usernameField = driver.findElement(AppiumBy.accessibilityId("test-Username"));
        usernameField.sendKeys(username);
    }

    @When("I enter password {string}")
    public void i_enter_password(String password) {
        WebElement passwordField = driver.findElement(AppiumBy.accessibilityId("test-Password"));
        passwordField.sendKeys(password);
    }

    @When("I tap the login button")
    public void i_tap_the_login_button() {
        WebElement loginBtn = driver.findElement(AppiumBy.accessibilityId("test-LOGIN"));
        loginBtn.click();
    }

    @Then("I should see the product page")
    public void i_should_see_the_product_page() {
        WebElement productTitle = driver.findElement(By.xpath("//android.widget.TextView[@text='PRODUCTS']"));
        assert productTitle.isDisplayed();
        driver.quit();
    }
}
