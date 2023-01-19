package es.upm.grise.prof2022.ex2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileIndirection {
	
	Properties file;
	
	void loadPropertyFile (Language language) throws FileNotFoundException, IOException {
		// Property filename
		String fileName = language.toString() + "-strings.properties";
		Properties file = new Properties();
		file.load(new FileInputStream("resources/" + fileName));
		this.file = file;
	}
	
	String getRequestedKey (String key) {
		// Find the requested string
		// Please notice that errors are possible, e.g., loadPropertyFile() not being previously invoked
		return file.getProperty(key);
	}

}
