package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class LanguageManipulationTest {

	@Test
	public void nonExistingKeyEnglishTest() throws Exception {
		LanguageManipulation lm = new LanguageManipulation();
		assertThrows(NonExistingKeyException.class, () -> lm.getText("nada", Language.English));
	}
	
	@Test
	public void nonExistingKeyNoEnglishTest() throws Exception {
		LanguageManipulation lm = new LanguageManipulation();
		assertEquals("This Key does not exist or it has not been yet translated", lm.getText("nada", Language.Spanish));
	}
	
	@Test
	public void fileNameNonExist() throws Exception {
		LanguageManipulation lm = new LanguageManipulation();
		assertThrows(CannotFindPropertyFileOrWrongFileException.class, () -> lm.getText("French", Language.Italian));
	}

}
