package PageObjects;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private final WebDriver driver;

	By logoutBtn = By.linkText("Log out");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateTo() {
		driver.get("https://www.demoblaze.com/");
	}

	public void clickSignUp() {
		driver.findElement(By.id("signin2")).click();
	}

	public void clickLogin() {
		driver.findElement(By.id("login2")).click();
	}

	public boolean isLogOutBtnDislayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
		WebElement logOut = driver.findElement(By.linkText("Log out"));

		return logOut.isDisplayed();

	}

	public void clickPhoneCategory() {
		driver.findElement(By.cssSelector(".list-group-item[onclick=\"byCat('phone')\"]")).click();

	}

	public void clickLaptopCategory() {
		driver.findElement(By.cssSelector(".list-group-item[onclick=\"byCat('notebook')\"]")).click();

	}

	public void ClickMonitorsCategory() {
		driver.findElement(By.cssSelector(".list-group-item[onclick=\"byCat('monitor')\"]")).click();

	}

	public int returnPageIteams() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		List<WebElement> elements = wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='col-lg-4 col-md-6 mb-4']")));

		return elements.size();
	}

	
	public void addRandomLaptopToCart() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	    // Wait for the presence of all elements
	    List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("a[class=\"hrefch\"]")));
	   // elements.get(0).click();
	    // get the len of productElems
	    int maxProducts = elements.size();
	    // get random number
	    Random random = new Random();
	    int randomProduct = random.nextInt(maxProducts);
	    // Select the list item
	    elements.get(randomProduct).click();



	}


}
