import org.testng.annotations.DataProvider;
import parsers.jaxb.AllSearchData;
import parsers.jaxb.SearchData;
import org.testng.annotations.Test;
import parsers.jaxb.XMLParser;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class testCartSum extends DefaultTest {
    private static final int TIME_TO_WAIT = 15;

    @DataProvider(name = "data2", parallel = true)
    public static Object[][] getData() {
        XMLParser xmlParser = new XMLParser();
        AllSearchData allSearchData = xmlParser.unmarshall();
        List<SearchData> searchDataList = allSearchData.getAllSearchData();
        Object[][] objArray = new Object[searchDataList.size()][];
        for (int i = 0; i < searchDataList.size(); i++) {
            objArray[i] = new Object[1];
            objArray[i][0] = searchDataList.get(i);
        }
        return objArray;
    }

    @Test(dataProvider = "data2")
    public void checkPrice(SearchData searchData) {
        getMainPage().searchByCategory(searchData.getKeyword());
        getSearchResultPage().loadPageWaiter(TIME_TO_WAIT);
        getSearchResultPage().scrollToSidebarSearch();
        getSearchResultPage().loadElementWaiter(TIME_TO_WAIT, getSearchResultPage().getSidebarSearch());
        getSearchResultPage().searchByBrand(searchData.getBrandName());
        getSearchResultPage().oneElementLeftWaiter(TIME_TO_WAIT, getSearchResultPage().getCheckboxList());
        getSearchResultPage().loadElementWaiter(TIME_TO_WAIT, getSearchResultPage().getBrandCheckbox());
        getSearchResultPage().clickOnBrandCheckbox();
        getSortedPage().sortByPriceDecrease();
        getSortedPage().loadPageWaiter(TIME_TO_WAIT);
        getSearchResultPage().loadElementWaiter(TIME_TO_WAIT, getSortedPage().getFirstElement());
        getSortedPage().clickOnFirstElement();
        getProductPage().loadPageWaiter(TIME_TO_WAIT);
        getProductPage().openIMGClick();
        getProductPage().loadElementWaiter(TIME_TO_WAIT, getProductPage().getBuyButton());
        getProductPage().clickOnBuyButton();
        getProductPage().loadElementWaiter(TIME_TO_WAIT, getProductPage().getCartSum());
        assertEquals(getProductPage().getCartSumValue(), Integer.parseInt(searchData.getPriceValidation()));
    }

}
