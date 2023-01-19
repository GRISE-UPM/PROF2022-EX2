package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LanguageManipulationTest {

	/*
	 * C1 = 15, 18-25, 26, Salida
	 * C2 = 15, 18-25, 30-33a, 33b, 34, Salida
	 * C3 = 15, 18-25, 30-33a, 38a, 42, Salida
	 * C4 = 15, 18-25, 30-33a, 33b, 38a, 42, Salida
	 * C5 = 15, 18-25, 30-33a, 33b, 38a, 38b, 42, Salida
	 * C6 = 15, 18-25, 30-33a, 33b, 38a, 38b, 39, 42, Salida
	 * 
	 * Se realizan test de los caminos:
	 	* C1 = Probar que se lanza la excepción cuando no se encuentra el fichero
	 	* C2 = Probar que se lanza la excepción cuando no se encuentra la clave en el fichero
	 	* C6 = Probar que se lanza la excepción cuando no se encuentra la clave en el fichero y el idioma es distinto de inglés
	 */

	static LanguageManipulation lm;
	static Language language;
	static String key;

	@BeforeAll
	public static void setUp() {
		lm = new LanguageManipulation();
		key = "key";
	}

	// Camino 1
	@Test
	public void catch_C1() {
		language = Language.Italian;
		assertThrows(CannotFindPropertyFileOrWrongFileException.class, () -> lm.getText(key, language));
	}

	// Camino 2
	@Test
	public void if_C2() {
		language = Language.English;
		assertThrows(NonExistingKeyException.class, () -> lm.getText(key, language));
	}

	// Camino 6
	@Test
	public void if_C6_2() {
		language = Language.Spanish;
		assertEquals("This Key does not exist or it has not been yet translated", assertDoesNotThrow(() -> lm.getText(key, language)));
	}

}
