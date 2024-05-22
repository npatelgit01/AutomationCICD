package rahulshettyacadamy.pageobjects;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.PublicEncryptionKey;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.AbsractComponentts.AbstractComponent;

public class Landingpage extends AbstractComponent {
	
	WebDriver driver;
	public Landingpage(WebDriver driver) 
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//driver.findElement(By.id("userEmail"));
	//PageFactory
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement login;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMsg;
	

	public ProductCatalogue loginApplication(String useremail, String pass) 
	{
		userEmail.sendKeys(useremail);
		userPassword.sendKeys(pass);
		login.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	public void GoTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String errorMessage() {
		waitForWebElementToAppear(errorMsg);
		System.out.println(errorMsg.getText());
		return errorMsg.getText();			
	}

	
	

}
