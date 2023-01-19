package es.upm.grise.prof2022.ex2;

import java.io.FileInputStream;
import java.util.Properties;

public class FilePropertiesManipulation {
	
	// Constructor
	public FilePropertiesManipulation() {
		
	}
	
	public String getTextFromProperty(String language, String key) throws CannotFindPropertyFileOrWrongFileException {
		// Property filename
		String fileName = language.toString() + "-strings.properties";
		Properties propertyFile = new Properties();

		// Load the property fileException
		// If the file does not exist, we raise an exception
		try {
			propertyFile.load(new FileInputStream("resources/" + fileName));
		} catch (Exception e) {
			throw new CannotFindPropertyFileOrWrongFileException();
		}

		// Find the requested string
		return propertyFile.getProperty(key);
	}

}
