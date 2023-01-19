package es.upm.grise.prof2022.ex2;

import java.io.FileInputStream;
import java.util.Properties;

public class LanguageFile {
	
	Language language;
	
	public LanguageFile(Language language) {
		super();
		this.language = language;
	}

	public Properties getPropertyFile() throws CannotFindPropertyFileOrWrongFileException{
		String fileName = language.toString() + "-strings.properties";
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
