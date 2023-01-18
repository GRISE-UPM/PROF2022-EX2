package es.upm.grise.prof2022.ex2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LanguageManipulation {

	// The strings are stored in property files under /resources
	// Each file corresponds to a Language
	// This method return the string associated with a key, e.g.,
	// translate("greeting", English) == "How are you?"
	// translate("greeting", Spanish) == "¿Cómo se encuentra?"
	//
	// See the smokeTest
	public String translate(String key, Language language) throws Exception {

		// Property filename
		String fileName = language.toString() + "-strings.properties";
		Properties file = new Properties();

		// Load the property file
		// If the file does not exist, we raise an exception
		try {
			file.load(new FileInputStream("resources/" + fileName));
		} catch (IOException e) {
			throw new CannotFindPropertyFileException();
		}

		// Find the requested string
		String translation = file.getProperty(key);


		if(translation == null && language == Language.English) { 
			throw new NonExistingKey();
		}

		if(translation == null && language != Language.English) { 
			translation = "This Key does not exist or it has not been yet translated";
		}

		return translation;
	}


}
