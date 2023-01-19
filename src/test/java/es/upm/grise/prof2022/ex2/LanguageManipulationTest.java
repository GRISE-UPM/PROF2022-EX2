package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class LanguageManipulationTest {


	@Test
	public void prueba_catch() {
		LanguageManipulation lengman;
		lengman= new LanguageManipulation();
		String key ="aaaaaa";
		assertThrows(CannotFindPropertyFileOrWrongFileException.class, ()->lengman.getText(key, Language.Italian));
		
	}
	
	//non-existing key English
	@Test
	public void prueba_if_1() {
		String key = "dfadsfasdfasdfasdf";
		LanguageManipulation lengman;
		lengman= new LanguageManipulation();
		assertThrows(NonExistingKeyException.class, ()-> lengman.getText(key, Language.English));
		
	}
	
	//non-existing key Italian
	@Test
	public void prueba_if_2() throws Exception {
		String key = "ASDFASDFASDF";
		String texto="This Key does not exist or it has not been yet translated";
		LanguageManipulation lengman = new LanguageManipulation();
		assertEquals(texto, lengman.getText(key, Language.Spanish));
		
	}

}
