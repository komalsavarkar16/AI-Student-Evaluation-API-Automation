package com.evaluation.api.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties = new Properties();
    
    static {
        try{
            FileInputStream file = new FileInputStream("src/test/resources/config/config.properties");
            properties.load(file);
        }
        catch(IOException e){
            throw new RuntimeException("Unable to load config.propertise file");
        }
    }
    public static String get(String key){
        return properties.getProperty(key);
    }

}
