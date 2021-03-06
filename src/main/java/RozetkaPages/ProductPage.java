package RozetkaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends DefaultPage {

    @FindBy(xpath = "//div/app-product-buy-btn/app-buy-button/button[contains(@class, 'button_with_icon button_color_green')]")
    WebElement buyButton;

    @FindBy(xpath = "//li[2]/a[contains(@class, 'tabs__link')]")
    WebElement productDescription;

    @FindBy(xpath = "//div[contains(@class, 'cart-receipt__sum-price')]/span[1]")
    WebElement cartSum;

    @FindBy(xpath = "//li[1]/rz-gallery-main-thumbnail-image/a/img[contains(@alt, '1')]")
    WebElement openIMG;

    public void clickOnBuyButton() {
        buyButton.click();
    }

    public void openIMGClick() {
        openIMG.click();
    }

    public int getCartSumValue() {
        return Integer.parseInt(cartSum.getText());
    }

    public WebElement getBuyButton() {
        return buyButton;
    }

    public WebElement getCartSum() {
        return cartSum;
    }

    public ProductPage(WebDriver driver) {
        super(driver);
    }

}
