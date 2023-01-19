package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LanguageManipulationTest{
	private static 	Access Ac;
	
	@Test
	public void FileInput_Test() throws Exception {
		
		LanguageManipulation lm = new LanguageManipulation();
		Ac = mock(Access.class);
		when(Ac.getString("Italian-strings.properties", "123")).thenThrow(CannotFindPropertyFileOrWrongFileException.class);
		assertThrows(CannotFindPropertyFileOrWrongFileException.class,()->lm.getText("greeting", Language.Italian));
	}
	
	@Test
	public void NullText_Test() throws Exception{
		LanguageManipulation lm = new LanguageManipulation();
		Ac = mock(Access.class);
		when(Ac.getString("","")).thenThrow(NonExistingKeyException.class);
		assertThrows(NonExistingKeyException.class,()->lm.getText(null, null));
	}
	
	@Test
	public void NoneEnglish_Test() throws NonExistingKeyException{
		LanguageManipulation lm = new LanguageManipulation();
		assertThrows(NonExistingKeyException.class,()->lm.getText(null, Language.English));
	}
	@Test
	public void LastIf_Test() throws Exception {
		Access ac = mock(Access.class);
		LanguageManipulation lm = new LanguageManipulation();
		assertEquals("This Key does not exist or it has not been yet translated", lm.getText("null", Language.Spanish));
	}
	
}

