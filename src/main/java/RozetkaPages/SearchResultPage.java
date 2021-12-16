package RozetkaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends DefaultPage {

    @FindBy(xpath = "//div[3]/div/rz-filter-searchline/div/input[contains(@class, 'sidebar-search__input')]")
    WebElement sidebarSearch;

    @FindBy(xpath = "//rz-filter-section-autocomplete/ul/li/a/label")
    WebElement brandCheckbox;

    public void searchByBrand(final String brandName){
        sidebarSearch.sendKeys(brandName);
    }

    public void clickOnBrandCheckbox(){
        brandCheckbox.click();
    }

    public void scrollToSidebarSearch(){
        Actions actions = new Actions(driver);
        actions.moveToElement(sidebarSearch);
    }

    public WebElement getSidebarSearch(){
        return sidebarSearch;
    }

    public WebElement getBrandCheckbox(){
        return brandCheckbox;
    }

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }
}
