package com.anastasiia.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties=new Properties();

    static{

        try{
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);
        }catch(IOException e){
            System.out.println("FILE IS NOT FOUND WITH A GIVEN PATH");
            e.printStackTrace();
        }
    }

    public static String getProperty(String keyWord){
        return properties.getProperty(keyWord);
    }

}
