package es.upm.grise.prof2022.ex2;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class LanguageManipulationProperties {
	
	String fileName;
	Properties propertyFile;
	String key;
	Language language;
	
	LanguageManipulationProperties(String key, Language language){
		this.fileName = language.toString() + "-strings.properties";
		this.propertyFile = new Properties();
		this.key=key;
		language = this.language;
	}
	
	public String getText(String key, Language language) throws CannotFindPropertyFileOrWrongFileException {
		this.generarResource();
		// Load the property fileException
		// If the file does not exist, we raise an exception
		try {
			this.load();
		} catch (Exception e) {
			throw new CannotFindPropertyFileOrWrongFileException();
		}
		// Find the requested string
		return this.getProperty();
	}
	
	public String generarResource() {
		String resource = "resources/" + fileName;
		return resource;
	}

	public void load() throws IOException {
		propertyFile.load(new FileInputStream(this.generarResource()));
	}

	public String getProperty() {
		return propertyFile.getProperty(key);
	}
	
	public Language getLanguage() {
		return this.language;
	}

}
