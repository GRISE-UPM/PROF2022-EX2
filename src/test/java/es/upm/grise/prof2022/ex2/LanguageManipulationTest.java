package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class LanguageManipulationTest {
	
	// camino basico 1: 15-23-25
	@Test
	public void unavailableLanguageFileTest() throws CannotFindPropertyFileOrWrongFileException{
		LanguageManipulation lm = new LanguageManipulation();
		LanguageFile languageFile = mock(LanguageFile.class);
		when(languageFile.getText("greeting", Language.Italian)).thenThrow(CannotFindPropertyFileOrWrongFileException.class);
		assertThrows(CannotFindPropertyFileOrWrongFileException.class,() -> lm.getText("greeting", Language.Italian, languageFile));
	}
	
	// camino basico 2: 15-23-33a-33b-34
	@Test
	public void emptyWordInEnglishTest() throws Exception {
		LanguageManipulation lm = new LanguageManipulation();
		LanguageFile languageFile = mock(LanguageFile.class);
		assertThrows(NonExistingKeyException.class,() -> lm.getText("", Language.English, languageFile));
	}
	
	// camino basico 3: 15-23-33a-33b-38a-38b-39-42
	@Test
	public void emptyWordNotInEnglishTest() throws Exception {
		LanguageManipulation lm = new LanguageManipulation();
		LanguageFile languageFile = mock(LanguageFile.class);
		assertEquals("This Key does not exist or it has not been yet translated", lm.getText("", Language.Spanish, languageFile));
	}

}
