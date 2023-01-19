package es.upm.grise.prof2022.ex2;

import org.junit.Assert;
import org.junit.Test;


public class LanguageManipulationTest {


	@Test
	public void testFirstCatch() {
		LanguageManipulation lm = new LanguageManipulation();
		CannotFindPropertyFileOrWrongFileException e = Assert.assertThrows("Unexisting Language", CannotFindPropertyFileOrWrongFileException.class, () -> lm.getText("aaaa", Language.Italian)); // Italian language not given
		// We would check e here if we did anything with it

	}


	@Test
	public void testFirstIf() {
		LanguageManipulation lm = new LanguageManipulation();
		NonExistingKeyException e = Assert.assertThrows("English Language", NonExistingKeyException.class, () -> lm.getText("aaaa", Language.English)); // Non existing key English case
		// We would check e here if we did anything with it

	}

	@Test
	public void testSecondIf() throws Exception{
		LanguageManipulation lm = new LanguageManipulation();
		Assert.assertEquals("This Key does not exist or it has not been yet translated", lm.getText("AAA", Language.Spanish)); // Non existing key in not english

	}

}
