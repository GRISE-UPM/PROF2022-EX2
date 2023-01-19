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
	public String getText(String key, Language language) throws Exception {

		// Property filename
		String fileName = language.toString() + "-strings.properties";
		Properties file = new Properties();

		// Load the property file
		// If the file does not exist, we raise an exception
		try {
			file.load(new FileInputStream("resources/" + fileName));
		} catch (IOException e) {
			throw new CannotFindPropertyFileOrWrongFileException();
		}

		// Find the requested string
		String text = file.getProperty(key);


		if(text == null && language == Language.English) { 
			throw new NonExistingKeyException();
		}

		if(text == null && language != Language.English) { 
			text = "This Key does not exist or it has not been yet translated";
		}

		return text;
	}


}
