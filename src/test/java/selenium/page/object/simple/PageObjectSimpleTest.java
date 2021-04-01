package selenium.page.object.simple;

import org.junit.jupiter.api.Test;
import selenium.AbstractSeleniumBaseTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

class PageObjectSimpleTest extends AbstractSeleniumBaseTest {

    @Test
    void yandexMarketPageObjectTest() {
        YandexMarketHomePage homePage = new YandexMarketHomePage(driver).open();
        YandexMarketCategoryPage categoryPage = homePage.openCategory("Компьютеры");
        YandexMarketProductsPage productsPage = categoryPage.openSubCategory("Ноутбуки");

        String firstProductName = productsPage.addProductToCompare(0);
        String secondProductName = productsPage.addProductToCompare(1);
        List<String> selectedProductNames = new ArrayList<>(Arrays.asList(firstProductName, secondProductName));
        YandexMarketComparePage comparePage = productsPage.clickCompareButton();
        List<String> comparedProductNames = comparePage.getProductTitles();

        assertThat(comparedProductNames, containsInAnyOrder(selectedProductNames.toArray(new String[selectedProductNames.size()])));
    }
}
