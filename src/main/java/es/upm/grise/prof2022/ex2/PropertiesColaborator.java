package es.upm.grise.prof2022.ex2;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesColaborator {
    // This class should access the property files

    public Properties loadColaborator(String fileName) throws CannotFindPropertyFileOrWrongFileException {
        Properties propertyFile = new Properties();

        // Load the property fileException
        // If the file does not exist, we raise an exception
        try {
            propertyFile.load(new FileInputStream("resources/" + fileName));
        } catch (Exception e) {
            throw new CannotFindPropertyFileOrWrongFileException();
        }
        return propertyFile;
    }
}
