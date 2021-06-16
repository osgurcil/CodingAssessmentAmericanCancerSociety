package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.SetUp;

public class AmericanCancerSociety extends SetUp {

    @Test
    public void cancerSociety() {
        driver.get("https://qa.donate.cancer.org/");

        //Image
        WebElement image = driver.findElement(By.xpath("//div[@class='image']"));
        image.isDisplayed();

        //Text
        WebElement text = driver.findElement(By.xpath("//h2"));
        String actualText = text.getText();
        String expectedText = "Give the gift of cancer research and patient support.";
        Assert.assertEquals(actualText, expectedText);

        //One Time
        driver.findElement(By.id("frequency_onetime")).click();
        WebElement amount1 = driver.findElement(By.xpath("(//div[@class='amount-item active'])[1]"));
        String actualAmount1 = amount1.getText();
        String expectedAmount1 = "$75";
        Assert.assertEquals(actualAmount1, expectedAmount1);

        //Monthly
        driver.findElement(By.id("frequency_monthly")).click();
        WebElement amount2 = driver.findElement(By.xpath("(//div[@class='amount-item active'])[2]"));
        String actualAmount2 = amount2.getText();
        String expectedAmount2 = "$21";
        Assert.assertEquals(actualAmount2,expectedAmount2);

        driver.quit();
    }
}
