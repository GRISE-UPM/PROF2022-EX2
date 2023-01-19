package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LanguageManipulationTest {

	LanguageManipulation l;
	
	@BeforeEach
	public void init() {
		l = new LanguageManipulation();
	}
	
	//caso de prueba ejercita el catch que es camino P2

	@DisplayName("Caso de prueba catch: P2")
	@Test
	public void testCatch()  throws Exception, CannotFindPropertyFileOrWrongFileException {
		String key = "";
		Language language = Language.Italian;
		assertThrows(CannotFindPropertyFileOrWrongFileException.class, ()->l.getText(key,language));
	}
	
	//otro el primer if, 
	@DisplayName("Caso de prueba primer if: P3")
	@Test
	public void testPrimerIf()  throws Exception, NonExistingKeyException {
		String key = "key";
		Language language = Language.English;
		assertThrows(NonExistingKeyException.class, ()->l.getText(key,language));
	}
	
	//y el tercer caso el segundo if del método getText().
	@DisplayName("Caso de prueba segundo if: P4")
	@Test
	public void testSegundoIf()  throws Exception, NonExistingKeyException {
		String key = "";
		Language language = Language.Spanish;
		String text = "This Key does not exist or it has not been yet translated";
		assertEquals(text, l.getText(key,language));
	}
}
