package com.acelu.pages;

import components.ProductComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage{

    private static final By PRODUCT_ITEM = By.cssSelector("div[class='inventory_item']");
    private static final By PRODUCTS_TITLE = By.className("product_label");
    private static final By PRODUCTS_CART_QTY = By.cssSelector("span[class='fa-layers-counter shopping_cart_badge']");

    public ProductsPage(WebDriver driver){
        super(driver);
    }

    public ArrayList<ProductComponent> getProductsList(){
        
        List<WebElement> productElements = waitElementsToBeClickable(PRODUCT_ITEM);
        ArrayList<ProductComponent> products = new ArrayList<>();

        for (WebElement webElement:productElements
             ) {
            products.add(new ProductComponent(driver,webElement,this));

        }

        return products;
    }

    public String getPageTitle(){
        return waitElementToBeClickable(PRODUCTS_TITLE).getText();
    }

    public String getCartProductsQty(){
        return waitElementToBeClickable(PRODUCTS_CART_QTY).getText();
    }
    
}
