package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LanguageManipulationTest {
	
	@Disabled
	@Test
	public void onLoadException() throws Exception {
		/* Path #1 */
		LanguageManipulationHelper lmh = Mockito.mock(LanguageManipulationHelper.class);
		LanguageManipulation lm = new LanguageManipulation();
		lm.setLmh(lmh);
		assertThrows(CannotFindPropertyFileOrWrongFileException.class, () -> lm.getText("farewell", Language.Italian));
	}
	
	@Test
	public void onNullEnglishText() throws Exception {
		/* Path 3 */
		LanguageManipulationHelper lmh = Mockito.mock(LanguageManipulationHelper.class);
		LanguageManipulation lm = new LanguageManipulation();
		lm.setLmh(lmh);
		assertThrows(NonExistingKeyException.class, () -> lm.getText("farewell", Language.English));
	}
	
	@Test
	public void onNullNonEnglishText() throws Exception {
		/* Path 4 */
		LanguageManipulationHelper lmh = Mockito.mock(LanguageManipulationHelper.class);
		LanguageManipulation lm = new LanguageManipulation();
		lm.setLmh(lmh);
		assertEquals("This Key does not exist or it has not been yet translated", lm.getText("farewell", Language.Spanish));
	}

}
