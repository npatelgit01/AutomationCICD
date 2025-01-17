package rahulshettyacadamy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Factory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;
import rahulshettyacademy.AbsractComponentts.AbstractComponent;

public class OrdersPage extends AbstractComponent {
	
	WebDriver driver;
	public OrdersPage(WebDriver driver) 
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> ProductNames;
	

	public boolean VerifyOrdersDisplaye1(String productName)  {
		boolean match = ProductNames.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}	

}
