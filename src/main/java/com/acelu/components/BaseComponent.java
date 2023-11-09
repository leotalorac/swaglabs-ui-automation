package com.acelu.components;

import com.acelu.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BaseComponent extends BasePage {


    protected WebElement rootElement;

    public BaseComponent(WebDriver driver, WebElement rootElement){
        super(driver);
        this.rootElement = rootElement;
    }

    public WebElement getRootElement(){
        return this.rootElement;
    }

    public WebElement waitForNestedElement(By locator){
        return wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(getRootElement(), locator));
    }


}
