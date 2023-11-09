package com.acelu.pages;

import com.acelu.components.ProductComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Require;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ProductsPage extends BasePage{

    // The idea for constants is taht are values that does not changes on the execution, when you apply operations like that could fail and fail for everything
    // For example could this happend
    //
    // By$ByCssSelector.class
    //
    // public ByCssSelector(String cssSelector) {
    //   super(
    //       "css selector",
    //       Require.argument("CSS selector", cssSelector)
    //           .nonNull("Cannot find elements when the selector is null"));

    //   this.cssSelector = cssSelector;
    // }
    private static final String PRODUCT_ITEM = "div[class='inventory_item']";
    private static final String PRODUCTS_TITLE = "product_label";
    private static final String PRODUCTS_CART_QTY ="span[class='fa-layers-counter shopping_cart_badge']";


    // Good name conventions and code organization

    public ProductsPage(WebDriver driver){
        super(driver);
    }
 
    public ArrayList<ProductComponent> getProductsList(){
        //This way you can try and catch errors and flow of the selecto as well
        List<WebElement> productElements = waitElementsToBeClickable(By.cssSelector(PRODUCT_ITEM));
        ArrayList<ProductComponent> products = new ArrayList<>();

        for (WebElement webElement:productElements
             ) {
            products.add(new ProductComponent(driver,webElement,this));
        }
        // Other option
        // List<ProductComponent> products = productElements.stream()
        //                                     .map(webElement->new ProductComponent(driver,webElement,this))
        //                                     .collect(Collectors.toList());

        return products;
    }

    public String getPageTitle(){
        return waitElementToBeClickable(By.className(PRODUCTS_TITLE)).getText();
    }

    public String getCartProductsQty(){
        return waitElementToBeClickable( By.cssSelector(PRODUCTS_CART_QTY)).getText();
    }
    //Great!!
}
