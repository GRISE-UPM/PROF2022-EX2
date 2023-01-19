package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class LanguageManipulationTest {
	
	static LanguageManipulation lM;

	// Test del camino 2
	@Test
	public void testC2() {
		lM = new LanguageManipulation();
		assertThrows(CannotFindPropertyFileOrWrongFileException.class, () -> lM.getText("greeting", Language.Italian));
	}
	
	// Test del camino 3
	@Test
	public void testC3() {
		lM = new LanguageManipulation();
		assertThrows(NonExistingKeyException.class, () -> lM.getText("test", Language.English));
	}
	
	// Test del camino 7
	@Test
	public void testC7() throws Exception {
		lM = new LanguageManipulation();
		assertEquals("How are you?", lM.getText("greeting", Language.English));
	}
	
	

}
