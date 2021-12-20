package RozetkaPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends DefaultPage{

    @FindBy(xpath = "//input[contains(@name, 'search')]")
    private WebElement searchLine;

    @FindBy (xpath = "//img[contains(@alt, \'Rozetka Logo\')]")
    private WebElement logoRozetka;

    @FindBy (xpath = "//img[contains(@class, 'top-information__picture')]")
    private WebElement topInfo;

    public void searchByCategory(final String keyword){
        searchLine.sendKeys(keyword + Keys.ENTER);
    }

    public WebElement topInfo(){ return topInfo;}

    public WebElement logoRozetka(){return logoRozetka; }

    public MainPage(WebDriver driver) {
        super(driver);
    }
}
