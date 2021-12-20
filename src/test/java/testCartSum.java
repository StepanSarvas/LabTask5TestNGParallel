import org.testng.annotations.DataProvider;
import parsers.jaxb.SearchData;
import org.testng.annotations.Test;
import parsers.jaxb.XMLParser;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class testCartSum extends DefaultTest{
    private static final int TIME_TO_WAIT = 15;
//    private static String keywordFromXML = parsers.jaxb.XMLParser.unmarshall().se;
//    private static String brandNameFromXML = parsers.jaxb.XMLParser.unmarshall().getBrandName();
//    private static String priceValidationFromXML = XMLParser.unmarshall().getPriceValidation();

    @DataProvider(name="data2")
    public static Object [][] getData(){
        XMLParser xmlParser= new XMLParser();
        parsers.jaxb.AllSearchData allSearchData = xmlParser.unmarshall();
        List<SearchData> searchDataList = allSearchData.getAllSearchData();
        Object [][] objArray = new Object[searchDataList.size()][];
        for(int i=0;i< searchDataList.size();i++){
            objArray[i] = new Object[1];
            objArray[i][0] = searchDataList.get(i);
        }
        return objArray;
    }

    @Test(dataProvider = "data2")
    public void checkPriceOfTV(SearchData searchData) throws InterruptedException {
        getMainPage().searchByCategory(searchData.getKeyword());
        getSearchResultPage().scrollToSidebarSearch();
        getSearchResultPage().loadElementWaiter(TIME_TO_WAIT, getSearchResultPage().getSidebarSearch());
        getSearchResultPage().searchByBrand(searchData.getBrandName());
        getSearchResultPage().oneElementLeftWaiter(TIME_TO_WAIT, getSearchResultPage().getCheckboxList());
        getSearchResultPage().loadElementWaiter(TIME_TO_WAIT, getSearchResultPage().getBrandCheckbox());
        getSearchResultPage().clickOnBrandCheckbox();
        getSortedPage().sortByPriceDecrease();
        getSortedPage().loadPageWaiter(TIME_TO_WAIT);
        getSortedPage().clickOnFirstElement();
        Thread.sleep(5000);
        getProductPage().loadElementWaiter(TIME_TO_WAIT, getProductPage().getProductDescription());
        getProductPage().clickOnProductDescription();
        getProductPage().loadElementWaiter(TIME_TO_WAIT, getProductPage().getBuyButton());
        getProductPage().clickOnBuyButton();
        getProductPage().loadElementWaiter(TIME_TO_WAIT, getProductPage().getCartSum());
        assertEquals(getProductPage().getCartSumValue(), Integer.parseInt(searchData.getPriceValidation()));
    }

    @Test()
    public void checkPriceOfSoundbar(){
        assertTrue(getMainPage().logoRozetka().isDisplayed());
    }

    @Test()
    public void checkPriceOfDisplay(){
        assertTrue(getMainPage().topInfo().isDisplayed());
    }

}
