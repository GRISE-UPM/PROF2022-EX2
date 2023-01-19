package es.upm.grise.prof2022.ex2;

import java.io.FileInputStream;
//import java.util.Properties;

public class LanguageManipulation {


	public String getText(String key, Language language) throws Exception {
		// Property filename
		// Load the property fileException
		// If the file does not exist, we raise an exception
	
		// Find the requested string
		String text = ColaboradoraPropiedades.getInstance().getProperty(key, language);

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
