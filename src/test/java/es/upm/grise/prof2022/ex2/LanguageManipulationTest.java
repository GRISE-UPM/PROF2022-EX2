package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class LanguageManipulationTest {

	@Test
	public void testPath1() throws Exception { // Camino 15 -18 - 19 - 23 - 24 - 26 - NF
		LanguageManipulation lm = Mockito.mock(LanguageManipulation.class);
		Assertions.assertThrows(CannotFindPropertyFileOrWrongFileException.class, () ->  lm.getText("greeting", Language.Italian));

	}
	
	@Test
	public void testPath2() throws Exception { // Camino 15 -18 - 19 - 23 - 24 - 30 - 33a - 33b - 34 - NF
		LanguageManipulation lm = Mockito.mock(LanguageManipulation.class);
		Assertions.assertThrows(NonExistingKeyException.class, () ->  lm.getText("bye", Language.English));
	}
	
	@Test
	public void testPath3() throws Exception { // Camino 15 -18 - 19 - 23 - 24 - 30 - 33a - 38a - 38b - 39 - 42 - NF
		LanguageManipulation lm = Mockito.mock(LanguageManipulation.class);
		assertEquals("This Key does not exist or it has not been yet translated",lm.getText("adios", Language.Spanish));
	}

}
