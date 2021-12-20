import Utils.WebDriverManager;
import parsers.jaxb.SearchData;
import RozetkaPages.MainPage;
import RozetkaPages.ProductPage;
import RozetkaPages.SearchResultPage;
import RozetkaPages.SortedPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;


public class DefaultTest {
    private WebDriver driver;
    private static final String ROZETKA_URL = "https://rozetka.com.ua/ua/";

    @BeforeTest
    public void profileSettings(){
    }

    @BeforeMethod
    public void testSettings(){
        driver = WebDriverManager.getDriver();
        driver.get(ROZETKA_URL);
    }


    @AfterMethod
    public void tearDown(){ driver.close(); }

    public WebDriver getDriver(){ return driver; }

    public MainPage getMainPage(){ return new MainPage(getDriver()); }

    public SearchResultPage getSearchResultPage(){ return new SearchResultPage(getDriver()); }

    public SortedPage getSortedPage(){ return new SortedPage(getDriver()); }

    public ProductPage getProductPage(){ return new ProductPage(getDriver()); }

}
