package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Properties;

import org.junit.jupiter.api.Test;

public class LanguageManipulationTest {
	
	static LanguageManipulation lM;
	NewFile newFile;

	/*
	 * // Test del camino 2
	 * 
	 * @Test public void testC2() { lM = new LanguageManipulation();
	 * assertThrows(CannotFindPropertyFileOrWrongFileException.class, () ->
	 * lM.getText("greeting", Language.Italian)); }
	 * 
	 * // Test del camino 3
	 * 
	 * @Test public void testC3() { lM = new LanguageManipulation();
	 * assertThrows(NonExistingKeyException.class, () -> lM.getText("test",
	 * Language.English)); }
	 * 
	 * // Test del camino 7
	 * 
	 * @Test public void testC7() throws Exception { lM = new
	 * LanguageManipulation(); assertEquals("How are you?", lM.getText("greeting",
	 * Language.English)); }
	 */
	
	// Test del camino 2
	@Test
	public void testC2Mock() throws Exception {
		newFile = mock(NewFile.class);
		lM = new LanguageManipulation(newFile);
		when(newFile.getText(Language.Italian, "greeting")).thenThrow(new CannotFindPropertyFileOrWrongFileException());
		assertThrows(CannotFindPropertyFileOrWrongFileException.class, () -> lM.getText("greeting", Language.Italian));
	}
	
	// Test del camino 3
	@Test
	public void testC3Mock() throws Exception {
		newFile = mock(NewFile.class);
		lM = new LanguageManipulation(newFile);
		when(newFile.getText(Language.English, "test")).thenReturn(null);
		assertThrows(NonExistingKeyException.class, () -> lM.getText("test", Language.English));
	}
	
	// Test del camino 7
	@Test
	public void testC7Mock() throws Exception {
		newFile = mock(NewFile.class);
		lM = new LanguageManipulation(newFile);
		when(newFile.getText(Language.English, "greeting")).thenReturn("How are you?");
		assertEquals("How are you?", lM.getText("greeting", Language.English));
	}
	
	

}
