package es.upm.grise.prof2022.ex2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ResourceAcces {
private String directory = "resources/";
private Properties propertyFile;
	public ResourceAcces() {}
	public ResourceAcces(String directory) {
		this.directory = directory;
	}
	public String getString(String resource, String key) throws Exception {
		propertyFile = new Properties();
		try {
			propertyFile.load(new FileInputStream(directory+ resource));
		} catch (Exception e) {
			throw new CannotFindPropertyFileOrWrongFileException();
		}
		
		
		return propertyFile.getProperty(key);
		
	}
	
	
}
