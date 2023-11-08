package com.test_project.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //1- create object of properties
    //make it private so its not accecible from outside of class (limiting access to object
    //static make sure that its created and loaded before everything else
    private static Properties properties = new Properties();

    static {
        try {
            //2- we need to open the file in the java memory using FileInputStream
            FileInputStream file = new FileInputStream("configuration.properties");
            //3- load the properties file in the properties object
            properties.load(file);
            //close file in the memory (optional)
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
        //create utility method to use object and read
        //4- use the "properties" object to read value from the file
    return properties.getProperty(keyword);

    }
}
