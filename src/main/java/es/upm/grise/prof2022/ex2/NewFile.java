package es.upm.grise.prof2022.ex2;

import java.io.FileInputStream;
import java.util.Properties;

public class NewFile {

	private Properties propertyFile;
	private String key;


	public String getText(Language language, String key) throws Exception {
		// Property filename
		String fileName = language.toString() + "-strings.properties";
		propertyFile.load(new FileInputStream("resources/" + fileName));
		return propertyFile.getProperty(key);
	}
	
	
	public Properties getPropertyFile() {
		return propertyFile;
	}
	
	public void setPropertyFile(Properties propertyFile) {
		this.propertyFile = propertyFile;
	}
	
	public String getPropertyKey() {
		return propertyFile.getProperty(key);
	}
	
	public void setPropertyKey(String key) {
		this.key = key;
	}
	
	
	

}
