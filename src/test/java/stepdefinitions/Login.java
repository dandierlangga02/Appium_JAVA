package stepdefinitions;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static hook.hooks.driver;

public class Login {

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
        Assert.assertTrue(productTitle.isDisplayed());
    }

    @Then("I Verify Error Massege")
    public void iVerifyErrorMassege() {
        WebElement Value = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Username and password do not match any user in this service.\"]"));
        String ActualValue = Value.getText();
        String ExpectedValue = "Username and password do not match any user in this service.";
        Assert.assertEquals(ExpectedValue, ActualValue);
    }
}