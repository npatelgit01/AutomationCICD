package rahulshettyacadamy.tests;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacadamy.TestComponents.BaseTest;
import rahulshettyacadamy.pageobjects.CartPage;
import rahulshettyacadamy.pageobjects.CheckoutPage;
import rahulshettyacadamy.pageobjects.ConfirmationPage;
import rahulshettyacadamy.pageobjects.Landingpage;
import rahulshettyacadamy.pageobjects.OrdersPage;
import rahulshettyacadamy.pageobjects.ProductCatalogue;


public class SubmitOrderTest extends BaseTest {

	private static final int String = 0;
	String productName= "ZARA COAT 3";	
		
	@Test(dataProvider = "getData", groups = {"purchase"})
	public void SubmitOrder(HashMap<String, String> data) {
		
		ProductCatalogue productCatalogue = landingpage.loginApplication(data.get("email"),data.get("password"));
		
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(data.get("product"));
		CartPage cartpage = productCatalogue.goToCartPage();
		
		boolean match = cartpage.VerifyProductDisplaye(data.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutpage = cartpage.gotoCheckout();
		
		String countryName = "India";
		checkoutpage.selectCountry(countryName );
		ConfirmationPage confirmationpage = checkoutpage.submitOrder();
		String confirmMessage = confirmationpage.getConfirmationMessage();
       
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));		
	}
	
	@Test(dependsOnMethods = {"SubmitOrder"})
	public void orderHistoryTest() {
		
		ProductCatalogue productCatalogue = landingpage.loginApplication("qa@mail.com", "Admin@123");
		OrdersPage orderspage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(orderspage.VerifyOrdersDisplaye1(productName));
		
	}
	
	@DataProvider 
	public Object[][] getData() throws IOException 
	{
		List<HashMap<String, String>> data = getjsonData((System.getProperty("user.dir") + "\\src\\test\\java\\rahulshettyacadamy\\data\\PurchaseOrder.json"),
				StandardCharsets.UTF_8);
 		return new Object[][] {{data.get(0)},{data.get(1)}};  
	}
}

	
	//We can also pass data with HAshmap


//We can write dataprovide like below also

/*
 * @DataProvider public Object[][] getData() { return new Object[][]
 * {{"qa@mail.com","Admin@123","ZARA COAT 3"},{"error@gmail.com",
 * "Admin@123","ADIDAS ORIGINAL"}} ; }
 */


/*
 * @DataProvider public Object[][] getData() throws IOException {
 * HashMap<String, String> map = new HashMap<String, String>(); map.put("email",
 * "qa@mail.com"); map.put("password", "Admin@123"); map.put("product",
 * "ZARA COAT 3");
 * 
 * HashMap<String, String> map1 = new HashMap<String, String>();
 * map1.put("email", "error@gmail.com"); map1.put("password", "Admin@123");
 * map1.put("product", "ADIDAS ORIGINAL");
 * 
 * 
 * 
 * return new Object[][] {{data.get(0)},{data.get(1)}} ; }
 */