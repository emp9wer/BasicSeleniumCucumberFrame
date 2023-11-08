package com.test_project.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {


    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);
            file.close();
        } catch (IOException e) {
            System.out.println("***!!!FILE NOT FOUND WITH GIVEN PATH!!!***");
            e.printStackTrace();
        }
    }


    /**
     * utility method to use object and read
     * @param keyword
     * @return
     */
    public static String getProperty(String keyword) {

    return properties.getProperty(keyword);

    }
}
