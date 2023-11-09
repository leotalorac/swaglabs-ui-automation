package com.acelu.components;

import com.acelu.pages.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductComponent extends BaseComponent{

    private static final By ADD_PRODUCT_BUTTON = By.cssSelector("button[class='btn_primary btn_inventory']");

    private ProductsPage productsPage;
    public ProductComponent(WebDriver driver, WebElement rootElement,ProductsPage productsPage){
        super(driver,rootElement);
        this.productsPage = productsPage;


    }

    public ProductComponent addProduct(){
        waitForNestedElement(ADD_PRODUCT_BUTTON).click();
        return this;
    }

    public ProductsPage getProductsPage(){
        return this.productsPage;
    }


}
