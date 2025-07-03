package stepdefinitions;

import hook.Base;
import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorting {
    @And("user click button Filter")
    public void UserClickFilter(){
        Base.driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")).click();
    }
    @And("user Choose Price low to high")
    public void UserchooseFilter(){
        Base.driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Price (low to high)\"]")).click();
    }

    @Then("user Verify Price Low to High")
    public void userVerifyPriceLowToHigh() {
        WebElement value1 = Base.driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"test-Price\" and @text=\"$7.99\"]"));
        WebElement value2 = Base.driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"test-Price\" and @text=\"$9.99\"]"));

        String ActualValue1 = value1.getText().replace("$", "");
        String ActualValue2 = value2.getText().replace("$", "");

        Double Actual1 = Double.parseDouble(ActualValue1);
        Double Actual2 = Double.parseDouble(ActualValue2);

        Assert.assertTrue(Actual1 < Actual2);
    }
    @And("user Choose Price High to Low")
    public void userChoosePriceHighToLow() {
        Base.driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Price (high to low)\"]")).click();
    }

    @Then("user Verify Price High to Low")
    public void userVerifyPriceHighToLow() {
        WebElement value1 = Base.driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"test-Price\" and @text=\"$49.99\"]"));
        WebElement value2 = Base.driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"test-Price\" and @text=\"$29.99\"]"));

        String ActualValue1 = value1.getText().replace("$", "");
        String ActualValue2 = value2.getText().replace("$", "");

        Double Actual1 = Double.parseDouble(ActualValue1);
        Double Actual2 = Double.parseDouble(ActualValue2);

        Assert.assertTrue(Actual1 > Actual2);

    }

    @And("user Choose A to Z")
    public void userChooseAToZ() {
        Base.driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Name (A to Z)\"]")).click();
    }

    @Then("user Verify A to Z")
    public void userVerifyAToZ() {
        List<WebElement> value1 = Base.driver.findElements(AppiumBy.accessibilityId("test-PRODUCTS"));

        List<String> actualList = new ArrayList<>();
        for (WebElement product : value1) {
            actualList.add(product.getText());
        }

        List<String> expectedList = new ArrayList<>(actualList);
        Collections.sort(expectedList); // urutkan A to Z

        Assert.assertEquals("Produk tidak diurutkan dari A ke Z", expectedList, actualList);
    }

    @And("user Choose Z to A")
    public void userChooseZToA() {
        Base.driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Name (Z to A)\"]")).click();
    }

    @Then("user Verify Z to A")
    public void userVerifyZToA() {
        List<WebElement> value1 = Base.driver.findElements(AppiumBy.accessibilityId("test-PRODUCTS"));

        List<String> actualList = new ArrayList<>();
        for (WebElement product : value1) {
            actualList.add(product.getText());
        }

        List<String> expectedList = new ArrayList<>(actualList);
        expectedList.sort(Collections.reverseOrder()); // urutkan Z to A

        Assert.assertEquals("Produk tidak diurutkan dari Z ke A", expectedList, actualList);
    }
}
