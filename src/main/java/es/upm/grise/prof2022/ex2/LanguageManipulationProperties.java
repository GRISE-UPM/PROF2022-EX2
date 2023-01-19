package es.upm.grise.prof2022.ex2;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class LanguageManipulationProperties {
	
	String fileName;
	Properties propertyFile;
	String key;
	
	LanguageManipulationProperties(String key, Language language){
		this.fileName = language.toString() + "-strings.properties";
		this.propertyFile = new Properties();
		this.key=key;
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
	
	

}
