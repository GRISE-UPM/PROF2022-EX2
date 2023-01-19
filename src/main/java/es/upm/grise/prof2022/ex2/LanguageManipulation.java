package es.upm.grise.prof2022.ex2;

import java.io.FileInputStream;
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
		LanguageManipulationProperties lmp = new LanguageManipulationProperties(key, language);

		// Load the property fileException
		// If the file does not exist, we raise an exception
		try {
			lmp.load();
		} catch (Exception e) {
			throw new CannotFindPropertyFileOrWrongFileException();
		}

		// Find the requested string
		String text = lmp.getProperty();

		// Non-existing key: case 1
		if(text == null && language == Language.English) { 
			throw new NonExistingKeyException();
		}
		
		// Non-existing key: case 2
		if(text == null && language != Language.English) { 
			text = "This Key does not exist or it has not been yet translated";
		}

		return text;
	}


}
