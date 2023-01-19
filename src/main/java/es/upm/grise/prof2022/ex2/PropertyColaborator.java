package es.upm.grise.prof2022.ex2;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyColaborator {
	
	Properties propertyFile;

	public String getText(String key, String fileName) throws CannotFindPropertyFileOrWrongFileException {
		propertyFile = new Properties();
		
		try {
			propertyFile.load(new FileInputStream("resources/" + fileName));
		} catch (Exception e) {
			throw new CannotFindPropertyFileOrWrongFileException();
		}
		
		return propertyFile.getProperty(key);
	}
	
}
