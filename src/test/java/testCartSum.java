import org.testng.annotations.Test;
import parsers.jaxb.XMLParser;

import static org.testng.AssertJUnit.assertEquals;

public class testCartSum extends DefaultTest{
    private static final int TIME_TO_WAIT = 15;
    private static String keywordFromXML = parsers.jaxb.XMLParser.unmarshall().getKeyword();
    private static String brandNameFromXML = parsers.jaxb.XMLParser.unmarshall().getBrandName();
    private static String priceValidationFromXML = XMLParser.unmarshall().getPriceValidation();

    @Test
    public void checkPriceOfItem(){
        getMainPage().searchByCategory(keywordFromXML);
        getSearchResultPage().scrollToSidebarSearch();
        getSearchResultPage().loadElementWaiter(TIME_TO_WAIT, getSearchResultPage().getSidebarSearch());
        getSearchResultPage().searchByBrand(brandNameFromXML);
        getSearchResultPage().loadElementWaiter(TIME_TO_WAIT, getSearchResultPage().getBrandCheckbox());
        getSearchResultPage().clickOnBrandCheckbox();
        getSortedPage().sortByPriceDecrease();
        getSortedPage().loadPageWaiter(TIME_TO_WAIT);
        getSortedPage().clickOnFirstElement();
        getProductPage().loadElementWaiter(TIME_TO_WAIT, getProductPage().getProductDescription());
        getProductPage().clickOnProductDescription();
        getProductPage().loadElementWaiter(TIME_TO_WAIT, getProductPage().getBuyButton());
        getProductPage().clickOnBuyButton();
        getProductPage().loadElementWaiter(TIME_TO_WAIT, getProductPage().getCartSum());
        assertEquals(getProductPage().getCartSumValue(), Integer.parseInt(priceValidationFromXML));
    }

}
