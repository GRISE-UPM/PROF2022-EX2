package es.upm.grise.prof2022.ex2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

final public class Collaborator {
	protected Properties propertyFile = new Properties();


	protected void loadProperty(InputStream inputStream) throws IOException {	
		propertyFile.load(inputStream);
	}
	
	
	protected String getProperty(String key) {
		return propertyFile.getProperty(key);
	}
}
