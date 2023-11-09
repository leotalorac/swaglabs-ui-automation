package com.acelu.tests;

import com.acelu.pages.ProductsPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tests {

    private WebDriver driver;

    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();

    }

    @Test
    public void loginTest(){
        ProductsPage page = new ProductsPage(driver);

        page.goTo("https://www.saucedemo.com/v1/")
                .login("standard_user","secret_sauce");

        Assertions.assertThat(page.getPageTitle())
                .describedAs("After login the Products page should be displayed")
                .isEqualTo("Products");
    }

    @Test
    public void addElementTest(){
        ProductsPage page = new ProductsPage(driver);

        page.goTo("https://www.saucedemo.com/v1/")
                .login("standard_user","secret_sauce")
                .getProductsList()
                .get(2)
                .addProduct();

        Assertions.assertThat(page.getCartProductsQty())
                .describedAs("One product should be in the cart")
                .isEqualTo("1");
    }

    @AfterEach
    public void afterEach(){
        if(driver != null){
            driver.quit();
        }
    }



}
