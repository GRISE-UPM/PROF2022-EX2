package es.upm.grise.prof2022.ex2;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFileSystem {

    private Properties properties;

    public PropertiesFileSystem(Properties properties) {
        this.properties = properties;
    }

    public String getProperty(String key, Language language) throws CannotFindPropertyFileOrWrongFileException {
        // Property filename
        String fileName = language.toString() + "-strings.properties";

        // Load the property fileException
        // If the file does not exist, we raise an exception
        try {
            this.properties.load(new FileInputStream("resources/" + fileName));
        } catch (Exception e) {
            throw new CannotFindPropertyFileOrWrongFileException();
        }

        // Find the requested string
        String text = this.properties.getProperty(key);
        return text;
    }
}
