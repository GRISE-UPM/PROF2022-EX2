package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class LanguageManipulationTest {
	
	@Test
	public void onLoadException() throws Exception {
		/* Path #1 */
		LanguageManipulation lm = new LanguageManipulation();
		assertThrows(CannotFindPropertyFileOrWrongFileException.class, () -> lm.getText("farewell", Language.Italian));
	}
	
	@Test
	public void onNullEnglishText() throws Exception {
		/* Path 3 */
		LanguageManipulation lm = new LanguageManipulation();
		assertThrows(NonExistingKeyException.class, () -> lm.getText("farewell", Language.English));
	}
	
	@Test
	public void onNullNonEnglishText() throws Exception {
		/* Path 4 */
		LanguageManipulation lm = new LanguageManipulation();
		assertEquals("This Key does not exist or it has not been yet translated", lm.getText("farewell", Language.Spanish));
	}

}
