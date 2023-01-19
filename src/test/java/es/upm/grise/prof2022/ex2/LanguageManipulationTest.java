package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class LanguageManipulationTest {
	
	FilePropertiesManipulation fileProperties = new FilePropertiesManipulation();
	LanguageManipulation lm = new LanguageManipulation(fileProperties);
	
	// Test para el camino C1 : 15 - 24 - 26
	@Test
	public void UnknownPropertyTest() {
		assertThrows(CannotFindPropertyFileOrWrongFileException.class, () -> lm.getText("greeting", Language.Italian));
	}
	
	// Test para el primer if , camino C2 : 15 - 24 - 30 - 33a - 33b - 34
	@Test
	public void NullKeyTest() {
		assertThrows(NonExistingKeyException.class, () -> lm.getText("Hi", Language.English));
	}
	
	// Test para el segundo if, camino C5: 15 - 24 - 30 - 33a - 33b - 38a - 38b - 39 - 42
	@Test
	public void NonExistingKeyTest() throws Exception {
		assertEquals("This Key does not exist or it has not been yet translated", lm.getText("avión", Language.Spanish));
	}
	
}
