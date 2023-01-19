package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class LanguageManipulationTest {
	
	@Test
	public void property_file_error_test() throws Exception{
		LanguageManipulation lm = new LanguageManipulation();;
		Language lan = Language.Italian;
		assertThrows(CannotFindPropertyFileOrWrongFileException.class,()->lm.getText(null,lan));
	}

	@Test
	public void null_text_and_english_language_test() throws Exception{
		LanguageManipulation lm = new LanguageManipulation();
		String key = "no_property";
		Language lan = Language.English;
		assertThrows(NonExistingKeyException.class,()->lm.getText(key,lan))
	}

	@Test
	public void text_and_spanish_languge_test() throws Exception{
		LanguageManipulation lm = new LanguageManipulation();
		String key = "no_property";
		Language lan = Language.Spanish;
		String text = "This Key does not exist or it has not been yet translated";
		assertEquals(text,lm.getText(key,lan));
	}

}
