package es.upm.grise.prof2022.ex2;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesCol { 
	
	Properties propertyFile;
	
	public PropertiesCol() {
		propertyFile = new Properties();
	}
	
	public void load(FileInputStream strm) throws Exception {
		propertyFile.load(strm);
	}
	
	public String getProperty(String key) {
		return propertyFile.getProperty(key);
	}
}
