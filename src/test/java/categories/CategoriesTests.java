package categories;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class CategoriesTests extends BaseTest {

    @Test
    public void testMonitorsCategory() {
        var categories = homePage.getCategories();
        categories.getListOfMonitors();
        List<WebElement> products = categories.listCategorySectionProducts();
        //System.out.println("Number of monitor products:"+ products.size());
        assertEquals(products.size(),2,"Incorrect Number of Product in Category");
    }

    @Test
    public void testLaptopsCategory(){
        var categories = homePage.getCategories();
        categories.getListOfLaptops();
        List<WebElement> products = categories.listCategorySectionProducts();
        //System.out.println("Number of Laptop products:"+ products.size());
        assertEquals(products.size(),6,"Incorrect Number of Product in Category");
    }
}
