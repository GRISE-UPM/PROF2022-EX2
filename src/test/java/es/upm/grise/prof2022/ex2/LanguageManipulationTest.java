package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class LanguageManipulationTest {

	@Test
	public void nonExistingKeyEnglishTest() throws Exception {
		PropertyColaborator pc = mock(PropertyColaborator.class);
		when(pc.getText("nada", "English-strings.properties")).thenReturn(null);
		LanguageManipulation lm = new LanguageManipulation(pc);
		assertThrows(NonExistingKeyException.class, () -> lm.getText("nada", Language.English));
	}
	
	@Test
	public void nonExistingKeyNoEnglishTest() throws Exception {
		PropertyColaborator pc = mock(PropertyColaborator.class);
		when(pc.getText("nada", "Spanish-strings.properties")).thenReturn(null);
		LanguageManipulation lm = new LanguageManipulation(pc);
		assertEquals("This Key does not exist or it has not been yet translated", lm.getText("nada", Language.Spanish));
	}
	
	@Test
	public void fileNameNonExist() throws Exception {
		PropertyColaborator pc = mock(PropertyColaborator.class);
		when(pc.getText("nada", "Italian-strings.properties")).thenThrow(new CannotFindPropertyFileOrWrongFileException());
		LanguageManipulation lm = new LanguageManipulation(pc);
		assertThrows(CannotFindPropertyFileOrWrongFileException.class, () -> lm.getText("nada", Language.Italian));
	}

}
