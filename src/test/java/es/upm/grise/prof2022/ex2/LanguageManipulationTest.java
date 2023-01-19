package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

//Los numeros de los caminos hacen referencia a la imagen del ejercicio 4
//y la imagen de este repositorio resources/imagen.jpeg
public class LanguageManipulationTest {

	/*
	 * Camino 1
	 * Ejercitamos el catch
	 */
	@Test
	public void camino1Test() {
		FileFactoryInterface m = mock(FileFactory.class);
		LanguageManipulation lm = new LanguageManipulation(m);
		assertThrows(CannotFindPropertyFileOrWrongFileException.class, () -> {
			when(m.openFile("key", Language.Italian)).thenThrow(CannotFindPropertyFileOrWrongFileException.class);
			lm.getText("key", Language.Italian);
		});
	}

	/*
	 * Camino 2
	 * Ejercitamos el primer if, lanzamos excepcion
	 */
	@Test
	public void camino2Test() throws CannotFindPropertyFileOrWrongFileException  {
		FileFactoryInterface m = mock(FileFactory.class);
		LanguageManipulation lm = new LanguageManipulation(m);

		
		try {
			when(m.openFile("key", Language.English)).thenReturn(null);
			//when(m.openFile("key", Language.English)).thenThrow(NonExistingKeyException.class);
		} catch (Exception e) {
			fail();
			e.printStackTrace();
		}

		assertThrows(NonExistingKeyException.class, () -> {
			lm.getText("key", Language.English);
		});
	}

	/*
	 * Camino 6
	 * Ejercitamos el segundo if, obtenemos un mensaje
	 */
	@Test
	public void camino6Test() {
		FileFactoryInterface m = mock(FileFactory.class);
		LanguageManipulation lm = new LanguageManipulation(m);
		String text = "";
		String res = "This Key does not exist or it has not been yet translated";
		try {
			when(m.openFile("greeting", Language.Spanish)).thenReturn(null);
			text = lm.getText("greeting", Language.Spanish);
		} catch (Exception e) {
			fail();
			e.printStackTrace();
		}
		assertEquals(res, text);
		
	}

}
