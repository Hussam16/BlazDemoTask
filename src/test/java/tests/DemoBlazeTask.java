package tests;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import PageObjects.CartPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.ProductPage;

public class DemoBlazeTask {
	private WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private ProductPage productPage;
	private CartPage cartPage;


	@BeforeMethod
	public void setUp() {
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		productPage = new ProductPage(driver);
		cartPage = new CartPage(driver);

	}

	@Test
	public void SignUpBlazeDemo() {
		homePage.navigateTo();
		homePage.clickSignUp();
		loginPage.userRgisteration(new Faker().funnyName().name(), "asd");
		Assert.assertEquals(loginPage.getAlertTextMsg(), "Sign up successful.");

	}

	@Test
	public void LoginBlazeDemo() {
		homePage.navigateTo();
		homePage.clickLogin();
		loginPage.userSignIn();
		Assert.assertTrue(homePage.isLogOutBtnDislayed());

	}

	@Test
	public void categoriesHasItems() throws InterruptedException {
		homePage.navigateTo();
		homePage.ClickMonitorsCategory(); // has 2 items
		Assert.assertTrue(homePage.returnPageIteams() > 0);
		homePage.clickLaptopCategory();
		Assert.assertTrue(homePage.returnPageIteams() > 0);
		homePage.clickPhoneCategory();
		Assert.assertTrue(homePage.returnPageIteams() > 0);

	}

	@Test
	public void addRandomItemToCart() throws InterruptedException {
		homePage.navigateTo();
		homePage.addRandomLaptopToCart();
		productPage.clickOnAddToCart();
		Assert.assertEquals(productPage.getAlertTextMsg(), "Product added");

	}

	@Test
	public void deleteRandomProduct() throws InterruptedException {
		homePage.navigateTo();
		homePage.addRandomLaptopToCart();
		productPage.clickOnAddToCart();
		Assert.assertEquals(productPage.getAlertTextMsg(), "Product added");
		cartPage.naviagetTOCart();
		cartPage.deleteProduct();
		Assert.assertTrue(cartPage.verifyDeleteOFProduct());
	}
	
	@Test
	public void placeorder() throws InterruptedException {
		homePage.navigateTo();
		homePage.addRandomLaptopToCart();
		productPage.clickOnAddToCart();
		cartPage.naviagetTOCart();
		Assert.assertEquals("OK", cartPage.clickPlaceorderButton());;
		//Thread.sleep(1000);	
	}
	
	
	

	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}

}
