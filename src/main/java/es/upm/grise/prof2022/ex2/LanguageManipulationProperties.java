package es.upm.grise.prof2022.ex2;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class LanguageManipulationProperties {
	
	Properties propertyFile;
	
	LanguageManipulationProperties(){
		propertyFile = new Properties();
	}

	public void load(FileInputStream fileInputStream) throws IOException {
		// TODO Auto-generated method stub
		propertyFile.load(fileInputStream);
		
	}

	public String getProperty(String key) {
		// TODO Auto-generated method stub
		return propertyFile.getProperty(key);
	}

}
