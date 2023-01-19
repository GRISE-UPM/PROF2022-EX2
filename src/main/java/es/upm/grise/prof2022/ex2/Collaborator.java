package es.upm.grise.prof2022.ex2;

import java.io.FileInputStream;
import java.util.Properties;

public class Collaborator {

    Properties propertyFile;

    public Collaborator(String fileName) throws CannotFindPropertyFileOrWrongFileException {
        propertyFile = new Properties();

        // Load the property fileException
        // If the file does not exist, we raise an exception
        try {
            propertyFile.load(new FileInputStream("resources/" + fileName));
        } catch (Exception e) {
            throw new CannotFindPropertyFileOrWrongFileException();
        }
    }

    public String getProperty(String key) {
        return propertyFile.getProperty(key);
    }
}
