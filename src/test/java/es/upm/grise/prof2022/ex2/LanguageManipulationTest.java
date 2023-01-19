package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LanguageManipulationTest {

//	@Test
//	public void smokeTest() throws Exception {
//		LanguageManipulation lm = new LanguageManipulation();
//		assertEquals("How are you?", lm.getText("greeting", Language.English));
//		assertEquals("¿Cómo se encuentra?", lm.getText("greeting", Language.Spanish));
//		assertThrows(CannotFindPropertyFileOrWrongFileException.class, () -> lm.getText("greeting", Language.Italian));
//	}

	LanguageManipulation lm = new LanguageManipulation(Mockito.mock(PropertiesFileSystem.class));

	//test correspondiente al Path I
	@Test
	public void testGetTextShouldThrowFindPropertyException() throws Exception {
		assertThrows(CannotFindPropertyFileOrWrongFileException.class, () -> lm.getText("greeting", Language.Italian));
	}

	//test correspondiente al Path II
	@Test
	public void testGetTextShouldThrowNonExistingException() throws Exception {
		assertThrows(NonExistingKeyException.class, () -> lm.getText("welcome", Language.English));
	}

	//test correspondiente al Path III
	@Test
	public void testGetTextShouldReturnTextNonExisting() throws Exception {
		assertEquals("This Key does not exist or it has not been yet translated", lm.getText("welcome", Language.Spanish));
	}


}
