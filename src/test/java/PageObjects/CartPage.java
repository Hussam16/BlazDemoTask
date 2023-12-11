package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CartPage {

	private final WebDriver driver;
	private By deleteLink = By.partialLinkText("Delete");
	private By placeOrderButton=By.cssSelector("button[class='btn btn-success']");
	private By name = By.id("name");
	private By creditcard = By.id("card");
	private By purchaseButton=By.xpath("//button[contains(text(),'Purchase')]");
	private By successMessage=By.xpath("//button[@class='confirm btn btn-lg btn-primary' and @tabindex='1' and contains(@style, 'display: inline-block;')]");
	

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	public void naviagetTOCart() {
		driver.findElement(By.linkText("Cart")).click();
	}

	public void deleteProduct() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(deleteLink));
		driver.findElement(deleteLink).click();
		driver.navigate().refresh();
	}

	public boolean verifyDeleteOFProduct() {

		WebElement deleteLinkAfterDeletion = null;
		try {
			// Try to find the delete link; this will throw an exception if the element is
			// not found
			deleteLinkAfterDeletion = driver.findElement(deleteLink);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// The element is not found, meaning it disappeared
		}

		// Verify that the delete link is not present after deletion
		if (deleteLinkAfterDeletion == null) {
			return true;
		} else {
			return false;
		}

	}




public String clickPlaceorderButton() {
	
	driver.findElement(placeOrderButton).click();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.elementToBeClickable(name));
	driver.findElement(name).sendKeys("hussam");
	driver.findElement(creditcard).sendKeys("4444");
	 wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.elementToBeClickable(purchaseButton));
	driver.findElement(purchaseButton).click();
	return driver.findElement(successMessage).getText();
	
	
}


}
