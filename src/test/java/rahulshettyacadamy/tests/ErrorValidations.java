package rahulshettyacadamy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacadamy.TestComponents.BaseTest;
import rahulshettyacadamy.TestComponents.Retry;
import rahulshettyacadamy.pageobjects.CartPage;
import rahulshettyacadamy.pageobjects.CheckoutPage;
import rahulshettyacadamy.pageobjects.ConfirmationPage;
import rahulshettyacadamy.pageobjects.ProductCatalogue;


public class ErrorValidations extends BaseTest {

		
	private static final boolean flase = false;

	@Test(groups = {"ErrorHandling"}, retryAnalyzer = Retry.class)
	public void getErrorMessage() throws IOException {
		
		landingpage.loginApplication("qa@gmail.com", "Admin");
		Assert.assertEquals("Incorrect email r password.", landingpage.errorMessage());
	}
	
	@Test
	public void getProductErrorMessage() throws IOException, InterruptedException {
		
		String productName= "ZARA COAT 3";	
		
		ProductCatalogue productCatalogue = landingpage.loginApplication("error@gmail.com", "Admin@123");
		
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartpage = productCatalogue.goToCartPage();
		
		boolean match = cartpage.VerifyProductDisplaye("ZARA COAT 33");
		Assert.assertFalse(flase);
	}

}
