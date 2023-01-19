package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.*;

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
		LanguageManipulation lm = new LanguageManipulation();
		assertThrows(CannotFindPropertyFileOrWrongFileException.class, () -> {
			lm.getText("key", Language.Italian);
		});
	}

	/*
	 * Camino 2
	 * Ejercitamos el primer if, lanzamos excepcion
	 */
	@Test
	public void camino2Test() {
		LanguageManipulation lm = new LanguageManipulation();
		try {
			lm.getText("greeting", Language.English);
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
		LanguageManipulation lm = new LanguageManipulation();
		String text = "";
		String res = "This Key does not exist or it has not been yet translated";
		try {
			text = lm.getText("key", Language.Spanish);
		} catch (Exception e) {
			fail();
			e.printStackTrace();
		}
		assertEquals(res, text);
		
	}

}
