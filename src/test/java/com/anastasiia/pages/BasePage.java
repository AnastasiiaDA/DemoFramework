package com.anastasiia.pages;

import com.anastasiia.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@data-id='search-query']")
    public WebElement searchBox;

    @FindBy(css = "[role=\'menubar\']>li")
    public List<WebElement> menuBar;

    @FindBy(xpath = "//div[@data-appears-component-name='Homepage_Vesta_ApiSpec_ContentfulSearchBubbles']//ul/li")
    public List<WebElement> searchBubbles;

    public void navigateToModule(String moduleName){

    }



}
