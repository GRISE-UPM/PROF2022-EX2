package es.upm.grise.prof2022.ex2;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesAccess {

    public String getText(String key, Language language) throws Exception {
        String fileName = language.toString() + "-strings.properties";
        Properties propertyFile = new Properties();
        // Load the property file
        // If the file does not exist, we raise an exception
        try {
            propertyFile.load(new FileInputStream("resources/" + fileName));
        } catch (Exception e) {
            throw new CannotFindPropertyFileOrWrongFileException();
        }
        // Find the requested string
        String text = propertyFile.getProperty(key);
        // Non-existing key: case 1
        if(text == null && language == Language.English) { 
            throw new NonExistingKeyException();
        }
        // Non-existing key: case 2
        if(text == null && language != Language.English) { 
            text = "This Key does not exist or it has not been yet translated";
        }
        return text;
    }
    
}
