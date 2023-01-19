package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LanguageManipulationTest {

	private static ResourceAcces accesoRec;
	private static LanguageManipulation lm;
	@BeforeAll
	public static void init() {
		accesoRec = mock(ResourceAcces.class);
		 lm = new LanguageManipulation(accesoRec);
	}
	//Pertenece a P2
	@Test
	public void catch_first_exception_test() throws Exception {

		when(accesoRec.getString("Italian-strings.properties", "greeting")).thenThrow(CannotFindPropertyFileOrWrongFileException.class);
		assertThrows(CannotFindPropertyFileOrWrongFileException.class, () -> lm.getText("greeting", Language.Italian));
	}
	
	//Pertenece a P3
	@Test
	public void first_if_test_true() throws Exception {
		when(accesoRec.getString("English-strings.properties", "")).thenThrow(NonExistingKeyException.class);

		assertThrows(NonExistingKeyException.class, () -> lm.getText("", Language.English));
		
	}
	
	//Pertenece a P1
	@Test
	public void second_if_test_second_cond() throws Exception {
		when(accesoRec.getString("Spanish-strings.properties", "")).thenReturn("This Key does not exist or it has not been yet translated");
		assertEquals("This Key does not exist or it has not been yet translated", lm.getText("", Language.Spanish));
		
	}

}
