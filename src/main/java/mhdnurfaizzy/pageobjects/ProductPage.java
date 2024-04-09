package mhdnurfaizzy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mhdnurfaizzy.AbstractComponenet.abstractComponent;

public class ProductPage extends abstractComponent{
	WebDriver driver;
	
	public ProductPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#btn-add-to-cart")
	 WebElement btnAddToCart;
	@FindBy(css="#btn-add-to-cart")
	 WebElement btnBuyNow;
	@FindBy(css="#btn-add-to-cart")
	 WebElement btnAddQty;
	@FindBy(css="#btn-add-to-cart")
	 WebElement btnLowQty;
	@FindBy(css=".message.text-xs.leading-normal.font-bold")
	 WebElement successMesaggeAddToCart;
	
	
	public void addProductToCart() {
		waitWebElementForAppear(btnAddToCart);
		btnAddToCart.click();
	
	}
	
	public String getTextMessaggeAddToCart() {
		waitWebElementForAppear(successMesaggeAddToCart);
		return successMesaggeAddToCart.getText();
	}
	
	
}
