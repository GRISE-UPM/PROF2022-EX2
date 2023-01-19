package es.upm.grise.prof2022.ex2;

import java.io.FileInputStream;
import java.util.Properties;

public class LanguageManipulationHelper {
	
	public String getText(String key, Language language) throws Exception {
		
		// Property filename
		String fileName = language.toString() + "-strings.properties";
		Properties propertyFile = new Properties();
		try {
			propertyFile.load(new FileInputStream("resources/" + fileName));
		} catch (Exception e) {
			throw new CannotFindPropertyFileOrWrongFileException();
		}
		// Find the requested string
		String text = propertyFile.getProperty(key);
		return text;
	}

}
