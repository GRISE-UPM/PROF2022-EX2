package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.io.FileInputStream;

import org.junit.jupiter.api.Test;

public class LanguageManipulationTest {
	
	/**
	 * Prueba de camino básico 1: // Load the property fileException
	 */
	@Test
	public void catchException_test() {
		Collaborator collaborator = mock(Collaborator.class);
		LanguageManipulation lm = new LanguageManipulation(collaborator);
		
		when(collaborator.loadProperty(new FileInputStream("resources/Italian-strings.properties"))).thenThrow(CannotFindPropertyFileOrWrongFileException.class);
		
		assertThrows(CannotFindPropertyFileOrWrongFileException.class, () -> lm.getText("greeting", Language.Italian));
	}
	
	
	/**
	 * Prueba de camino básico 2: Non-existing key: case 1
	 */
	@Test
	public void NonExistingKeyException_test() {
		Collaborator collaborator = mock(Collaborator.class);

		LanguageManipulation lm = new LanguageManipulation(collaborator);
		
		when(collaborator.getProperty("")).thenThrow(NonExistingKeyException.class);
		assertThrows(NonExistingKeyException.class, () -> lm.getText("", Language.English));
	}
	

	/**
	 * Prueba de camino básico 5:  Non-existing key: case 2
	 * @throws Exception 
	 */
	@Test
	public void NonExistingKey_test() throws Exception {
		Collaborator collaborator = mock(Collaborator.class);

		LanguageManipulation lm = new LanguageManipulation(collaborator);
		String result = "This Key does not exist or it has not been yet translated";
		
		when(collaborator.getProperty("saludo")).thenReturn("This Key does not exist or it has not been yet translated");
		assertEquals(result, lm.getText("saludo", Language.Spanish));
	}
	
}
