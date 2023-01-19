package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class LanguageManipulationTest {

	// Test - First catch block
	@Test
	public void testFirstCatchBlock() throws Exception {
		LanguageManipulation lm = new LanguageManipulation();
		assertThrows(CannotFindPropertyFileOrWrongFileException.class, () -> lm.getText("does-not-matter", Language.Italian));
	}

	// Test - non-existing key in English
	// key parameter is set to non-existing-key since there is only one key in the English property file called greeting
	@Test
	public void testNonExistingKeyInEnglish() throws Exception {
		LanguageManipulation lm = new LanguageManipulation();
		assertThrows(NonExistingKeyException.class, () -> lm.getText("non-existing-key", Language.English));
	}

	// Test - non-existing key in Spanish
	// key parameter is set to clave-inexistente since there is only one key in the Spanish property file called greeting
	@Test
	public void testNonExistingKeyInSpanish() throws Exception {
		LanguageManipulation lm = new LanguageManipulation();
		assertEquals("This Key does not exist or it has not been yet translated", lm.getText("clave-inexistente", Language.Spanish));
	}
}
