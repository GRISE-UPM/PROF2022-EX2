package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LanguageManipulationTest {

	private LanguageManipulation lm;
	private static FilePropertiesManipulation fileProperties;

	@BeforeAll
	public static void init() {
		fileProperties = Mockito.mock(FilePropertiesManipulation.class);
	}

	// Test para el camino C1 : 15 - 24 - 26
	@Test
	public void UnknownPropertyTest() throws CannotFindPropertyFileOrWrongFileException {
		when(fileProperties.getTextFromProperty("greeting", Language.Italian.toString()))
				.thenThrow(CannotFindPropertyFileOrWrongFileException.class);
		lm = new LanguageManipulation(fileProperties);
		assertThrows(CannotFindPropertyFileOrWrongFileException.class, () -> lm.getText("greeting", Language.Italian));
	}

	// Test para el primer if , camino C2 : 15 - 24 - 30 - 33a - 33b - 34
	@Test
	public void NullKeyTest() throws CannotFindPropertyFileOrWrongFileException {
		when(fileProperties.getTextFromProperty("Hi", Language.English.toString()))
				.thenThrow(NonExistingKeyException.class);
		lm = new LanguageManipulation(fileProperties);
		assertThrows(NonExistingKeyException.class, () -> lm.getText("Hi", Language.English));
	}

	// Test para el segundo if, camino C5: 15 - 24 - 30 - 33a - 33b - 38a - 38b - 39 - 42
	@Test
	public void NonExistingKeyTest() throws Exception {
		String keyDoesNotExistString = "This Key does not exist or it has not been yet translated";
		when(fileProperties.getTextFromProperty("Hi", Language.English.toString())).thenReturn(keyDoesNotExistString);
		lm = new LanguageManipulation(fileProperties);
		assertEquals(keyDoesNotExistString, lm.getText("avión", Language.Spanish));
	}

}
