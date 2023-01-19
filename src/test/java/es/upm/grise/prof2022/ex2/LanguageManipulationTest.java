package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class LanguageManipulationTest {
	

	// Test de catch
	// Camino 1: 15-(18-19)-(23-25)-26-42
	@Test
	public void catchTest() {
		LanguageManipulation lm = new LanguageManipulation();
		assertThrows(CannotFindPropertyFileOrWrongFileException.class, () -> lm.getText("greeting", Language.Italian));
	}

	// Test de primer if
	// Camino 2: 15-(18-19)-(23-25)-30-33a-33b-34-42
	@Test
	public void firstIfTest() throws Exception {
		LanguageManipulation lm = new LanguageManipulation();
		LanguageManipulationProperties lmp = mock(LanguageManipulationProperties.class);
		
		when(lmp.getText("", Language.English)).thenThrow(NonExistingKeyException.class);

		
		assertThrows(NonExistingKeyException.class, () -> lm.getText("", Language.English));
	}
	
	// Test de segundo if
	// Camino 4: 15-(18-19)-(23-25)-30-33a-33b-35-38a-38b-39-42
	@Test
	public void secondIfTest() throws Exception {
		LanguageManipulation lm = new LanguageManipulation();
		LanguageManipulationProperties lmp = mock(LanguageManipulationProperties.class);
		
		when(lmp.getText("", Language.Spanish)).thenReturn("This Key does not exist or it has not been yet translated");
		
		assertEquals("This Key does not exist or it has not been yet translated", lm.getText("", Language.Spanish));
	}
	
	// El nodo 42 es el salida del método, he puesto 42 porque es un return pero el ultimo nodo tambien puede ser 43 que
	// es el cierre del método, igual con el camino 4 el nodo 35, he añadido porque es el cierre del primer if y es un nodo
	// para que se quede con más claridad.
}
