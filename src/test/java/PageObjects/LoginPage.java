package PageObjects;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;
 
	By userName=By.id("sign-username");
	By pass=By.id("sign-password");
	By RegisterButton=By.cssSelector("button[onclick='register()']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        
    }

	public void userRgisteration(String userNme, String password) {
		driver.findElement(userName).sendKeys(userNme);
		driver.findElement(pass).sendKeys(password);
		driver.findElement(RegisterButton).click();

	}
	
    public String getAlertTextMsg() {
    	
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
      return  alert.getText();
    }
    
    public void userSignIn() {
    	driver.findElement(By.id("loginusername")).sendKeys("BlazeTask");
    	driver.findElement(By.id("loginpassword")).sendKeys("Asd123@@");
    	driver.findElement(By.cssSelector("button[onclick='logIn()']")).click();
		
	}
    
}
