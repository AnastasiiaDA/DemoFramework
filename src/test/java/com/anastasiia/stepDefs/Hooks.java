package com.anastasiia.stepDefs;

import com.anastasiia.utils.ConfigurationReader;
import com.anastasiia.utils.DB_Util;
import com.anastasiia.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        Driver.closeDriver();
    }
    @Before("@db")
    public void setUpDB(){
        DB_Util.createConnection();
        System.out.println("Connected to database");
    }
    @After("@db")
    public void tearDownDB(){
        DB_Util.destroy();
        System.out.println("Connection to database is closed");
    }
}
