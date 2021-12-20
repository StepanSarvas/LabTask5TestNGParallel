package RozetkaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends DefaultPage {

    @FindBy(xpath = "//button[contains(@class, 'button_with_icon button_color_green')]/span")
    WebElement buyButton;

    @FindBy(xpath = "//li[1]/a[contains(@class, 'tabs__link')]")
    WebElement productDescription;

    @FindBy(xpath = "//div[contains(@class, 'cart-receipt__sum-price')]/span[1]")
    WebElement cartSum;

    public void clickOnBuyButton(){
        buyButton.click();
    }

    public void clickOnProductDescription(){
        productDescription.click();
    }

    public int getCartSumValue(){
        return Integer.parseInt(cartSum.getText());
    }

    public WebElement getBuyButton(){
        return buyButton;
    }

    public WebElement getProductDescription(){
        return productDescription;
    }

    public WebElement getCartSum(){
        return cartSum;
    }

    public ProductPage(WebDriver driver) {
        super(driver);
    }

}
