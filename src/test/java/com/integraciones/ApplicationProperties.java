package com.integraciones;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

import static com.ibm.icu.impl.ClassLoaderUtil.getClassLoader;

public class ApplicationProperties {


    private static Properties instance = null;
    private static final String APPLICATION_PREFIX = "application";
    private static final String APPLICATION_SUFFIX = "properties";
    static final Logger LOGGER = LoggerFactory.getLogger(ApplicationProperties.class);

    public static synchronized Properties getInstance(){
        if(instance == null){
            instance = loadPropertiesFile();
        }
        return instance;
    }
    private ApplicationProperties(){

    }
    private  static Properties loadPropertiesFile(){
    //  String environment = Optional.ofNullable(System.getenv("env")).orElse("apitesting");
        String environment = Optional.ofNullable(System.getProperty("env")).orElse("apitesting");
        String filename = String.format("%s-%s.%s",APPLICATION_PREFIX,environment,APPLICATION_SUFFIX);
        Properties pro = new Properties();
        try {
            pro.load(getClassLoader().getResourceAsStream(filename));
        }
        catch (IOException e)
        {
            LOGGER.error("ERROR: en la clase ApplicationProperties, en el método loadPropertiesFile: " + e);
        }
        return pro;
    }
}
