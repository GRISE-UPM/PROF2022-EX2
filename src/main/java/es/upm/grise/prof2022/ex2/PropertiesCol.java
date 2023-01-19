package es.upm.grise.prof2022.ex2;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesCol { 
	
	Properties propertyFile;
	
	public PropertiesCol() {
		propertyFile = new Properties();
	}
	
	public void load(FileInputStream strm, String filename) throws Exception {
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
