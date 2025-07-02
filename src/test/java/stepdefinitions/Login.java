package stepdefinitions;

import hook.Base;
import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Login {

    @Given("the app is launched")
    public void the_app_is_launched() {
        WebElement usernameField = Base.driver.findElement(AppiumBy.accessibilityId("test-Username"));
        Assert.assertTrue("App belum siap/tampilan login tidak muncul", usernameField.isDisplayed());
    }

    @When("I enter username {string}")
    public void i_enter_username(String username) {
        WebElement usernameField = Base.driver.findElement(AppiumBy.accessibilityId("test-Username"));
        usernameField.sendKeys(username);
    }

    @When("I enter password {string}")
    public void i_enter_password(String password) {
        WebElement passwordField = Base.driver.findElement(AppiumBy.accessibilityId("test-Password"));
        passwordField.sendKeys(password);
    }

    @When("I tap the login button")
    public void i_tap_the_login_button() {
        WebElement loginBtn = Base.driver.findElement(AppiumBy.accessibilityId("test-LOGIN"));
        loginBtn.click();
    }

    @Then("I should see the product page")
    public void i_should_see_the_product_page() {
        WebElement productTitle = Base.driver.findElement(By.xpath("//android.widget.TextView[@text='PRODUCTS']"));
        Assert.assertTrue(productTitle.isDisplayed());
    }

    @Then("I Verify Error Massege")
    public void iVerifyErrorMassege() {
        WebElement Value = Base.driver.findElement(By.xpath("//android.widget.TextView[@text=\"Username and password do not match any user in this service.\"]"));
        String ActualValue = Value.getText();
        String ExpectedValue = "Username and password do not match any user in this service.";
        Assert.assertEquals(ExpectedValue, ActualValue);
    }
}
