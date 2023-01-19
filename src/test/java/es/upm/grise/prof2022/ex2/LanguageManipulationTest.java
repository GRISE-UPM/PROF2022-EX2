package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class LanguageManipulationTest {

	//Pertenece a P2
	@Test
	public void catch_first_exception_test() {
		LanguageManipulation lm = new LanguageManipulation();
		
		assertThrows(CannotFindPropertyFileOrWrongFileException.class, () -> lm.getText("greeting", Language.Italian));
	}
	
	//Pertenece a P3
	@Test
	public void first_if_test_true() {
		LanguageManipulation lm = new LanguageManipulation();
		assertThrows(NonExistingKeyException.class, () -> lm.getText("", Language.English));
		
	}
	
	//Pertenece a P1
	@Test
	public void second_if_test_second_cond() throws Exception {
		LanguageManipulation lm = new LanguageManipulation();
		assertEquals("This Key does not exist or it has not been yet translated", lm.getText("", Language.Spanish));
		
	}

}
