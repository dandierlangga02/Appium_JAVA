package stepdefinitions;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import hook.Base;

public class EndToEnd {


    @Given("user Login app swag lab")
    public void UserLoginApp(){
        Base.driver.findElement(AppiumBy.accessibilityId("test-Username")).sendKeys("standard_user");
        Base.driver.findElement(AppiumBy.accessibilityId("test-Password")).sendKeys("secret_sauce");
        Base.driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();
    }


    @And("user see the product page")
    public void userSeeTheProductPage() {
        WebElement productTitle = Base.driver.findElement(By.xpath("//android.widget.TextView[@text='PRODUCTS']"));
        Assert.assertTrue(productTitle.isDisplayed());
    }


    @When("user click product Sauce Labs Backpack ADD TO CART")
    public void userClickProductSauceLabsBackpackADDTOCART() {
        Base.driver.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]")).click();
    }

    @And("user click product Sauce Labs Bike Light ADD TO CART")
    public void userClickProductSauceLabsBikeLightADDTOCART() {
        Base.driver.findElement(AppiumBy.accessibilityId("test-ADD TO CART")).click();
    }

    @And("user Verify Icon cart appears 2")
    public void userVerifyIconCartAppears() {
        WebElement value = Base.driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"2\"]"));
        String ActualValue = value.getText();
        String ExpectedValue = "2";
        Assert.assertEquals( ExpectedValue,ActualValue);
    }

    @And("user click Icon cart")
    public void userClickIconCart() {
        Base.driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView")).click();
    }

    @And("user click CHECKOUT")
    public void userClickCHECKOUT() {
        Base.driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().description(\"test-CHECKOUT\"))"
        ));
        Base.driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"CHECKOUT\"]")).click();
    }

    @And("user fill First Name")
    public void userFillFirstName() {
        Base.driver.findElement(AppiumBy.accessibilityId("test-First Name")).click();
        Base.driver.findElement(AppiumBy.accessibilityId("test-First Name")).sendKeys("Dandi");
    }

    @And("user fill Last Name")
    public void userFillLastName() {
        Base.driver.findElement(AppiumBy.accessibilityId("test-Last Name")).click();
        Base.driver.findElement(AppiumBy.accessibilityId("test-Last Name")).sendKeys("Erlangga");
    }

    @And("user fill Zip Code")
    public void userFillZipPostalCode() {
        Base.driver.findElement(AppiumBy.accessibilityId("test-Zip/Postal Code")).click();
        Base.driver.findElement(AppiumBy.accessibilityId("test-Zip/Postal Code")).sendKeys("12345");
    }

    @And("user click CONTINUE")
    public void userClickCONTINUE() {
        Base.driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().description(\"test-CONTINUE\"))"
        ));
        Base.driver.findElement(AppiumBy.accessibilityId("test-CONTINUE")).click();
    }

    @And("user click Finish")
    public void userClickFinish() {
        Base.driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().description(\"test-FINISH\"))"
        ));
        Base.driver.findElement(AppiumBy.accessibilityId("test-FINISH")).click();
    }

    @Then("user verify wording  Checkout : Complete!")
    public void userVerifyWordingCheckoutComplete() {
        WebElement value = Base.driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"CHECKOUT: COMPLETE!\"]"));
        String ActualValue = value.getText();
        String ExpectedValue = "CHECKOUT: COMPLETE!";
        Assert.assertEquals( ExpectedValue,ActualValue);
    }
}
