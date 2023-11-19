package PageObjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ProductPage {

	 private final WebDriver driver;
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        
    }
    
    public void clickOnAddToCart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement priceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3.price-container")));
        if (priceElement.isDisplayed()) {
            WebElement button = driver.findElement(By.linkText("Add to cart"));
            button.click();
        }

        
    }
    public String getAlertTextMsg() {
    	
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        String txt=alert.getText();
        alert.accept();
      return  txt;
    }
    
}
