package rahulshettyacademy.AbsractComponentts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacadamy.pageobjects.CartPage;
import rahulshettyacadamy.pageobjects.OrdersPage;

public class AbstractComponent {
	
	WebDriver driver;

		//Constructor
	public AbstractComponent(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cart;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement order;
	
	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementToAppear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void waitForElementToDisAppear(WebElement spinner) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(spinner));
	}
	//Click on Cart
	public CartPage goToCartPage() {
		
		cart.click();
		CartPage cartpage = new CartPage(driver);
		return cartpage;
	}
	//Click on Order
		public OrdersPage goToOrdersPage() {
			
			order.click();
			OrdersPage orderspage = new OrdersPage(driver);
			return orderspage;
		}
	
}
