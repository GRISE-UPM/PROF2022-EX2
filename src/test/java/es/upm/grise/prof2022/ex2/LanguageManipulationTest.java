package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class LanguageManipulationTest {

	/*
	 * C2: 15,18,19 - 24 - 26 - 43
	 */
	@Test
	public void catchTest() {
		LanguageManipulation lm = new LanguageManipulation();
		assertThrows(CannotFindPropertyFileOrWrongFileException.class,
				() -> lm.getText("greeting", Language.Italian));
	}

	/*
	 * C6: 15,18,19 - 24 - 30 - 33a - 33b - 34 - 43
	 */
	@Test
	public void firstIfTest() {
		LanguageManipulation lm = new LanguageManipulation();
		assertThrows(NonExistingKeyException.class,
				() -> lm.getText("farewell", Language.English));
	}

	/*
	 * C8: 15,18,19 - 24 - 30 - 33a - 38a - 38b - 39 - 42 - 43
	 */
	@Test
	public void secondIfTest() throws Exception {
		LanguageManipulation lm = new LanguageManipulation();
		assertEquals("This Key does not exist or it has not been yet translated",
				lm.getText("farewell", Language.Spanish));
	}
}
