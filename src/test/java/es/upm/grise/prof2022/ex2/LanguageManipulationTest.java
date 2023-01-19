package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.FileInputStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LanguageManipulationTest {
	
	// Variables
	private static LanguageManipulation lm;
	private static PropertiesCol pc;
	private String ky;
	private Language lg;
	
	@BeforeAll
	public static void init () {
		
		// Initialization
		lm = new LanguageManipulation();
		pc = mock(PropertiesCol.class);
	}
	
	/*
	 * Test relativo al camino C1:
	 * 	Llamada - 15 - 26 - Salida
	 */
	@Test
	public void catchTest() {
		
		// Initialization
		ky = "foo";
		lg = Language.Italian;
		
		when(pc.load(any(FileInputStream.class))).thenThrow(new Exception());
		
		// Assertion
		assertThrows(CannotFindPropertyFileOrWrongFileException.class, () -> {
			lm.getText(ky, lg, pc);
		});
	}
	
	/*
	 * Test relativo al camino C2:
	 * 	Llamada - 15 - 28 - 33 - 34 - Salida
	 */
	@Test
	public void if1Test() {
		
		// Initialization
		ky = "foo";
		lg = Language.English;
		
		// Assertion
		assertThrows(NonExistingKeyException.class, () -> {
			lm.getText(ky, lg, pc);
		});
	}

	/*
	 * Test relativo al camino C6:
	 * 	Llamada - 15 - 28 - 38a - 38b - 39 - 42 - Salida
	 */
	@Test
	public void if2Test() {
	
		// Initialization
		ky = "foo";
		lg = Language.Spanish;

		// Assertion
		try {
			assertEquals(lm.getText(ky, lg, pc), "This Key does not exist or it has not been yet translated");
		} catch (Exception e) {
			fail("No debería haber lanzado Exception");
		}
	}
}
