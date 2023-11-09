package com.acelu.components;

import com.acelu.pages.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductComponent extends BaseComponent{
    //Same recomendation with constants
    private static final By ADD_PRODUCT_BUTTON = By.cssSelector("button[class='btn_primary btn_inventory']");

    private ProductsPage productsPage;
    public ProductComponent(WebDriver driver, WebElement rootElement,ProductsPage productsPage){
        super(driver,rootElement);
        this.productsPage = productsPage;
    }

    // Why not to use a void function if it is an operation?
    public void addProduct(){
        waitForNestedElement(ADD_PRODUCT_BUTTON).click();
    }
    
    public ProductsPage getProductsPage(){
        return this.productsPage;
    }


}
