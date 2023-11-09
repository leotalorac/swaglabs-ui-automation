package com.acelu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private static final By USERNAME_TEXTBOX = By.id("user-name");
    private static final By PASSWORD_TEXTBOX = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public LoginPage writeUsername(String username){
        waitElementToBeClickable(USERNAME_TEXTBOX).sendKeys(username);
        return this;
    }

    public LoginPage writePassword(String password){
        waitElementToBeClickable(PASSWORD_TEXTBOX).sendKeys(password);
        return this;
    }

    public ProductsPage sendCredentials(){
        waitElementToBeClickable(LOGIN_BUTTON).click();
        return new ProductsPage(driver);
    }

    public ProductsPage login(String username, String password){
        return writeUsername(username)
                .writePassword(password)
                .sendCredentials();
    }





}
