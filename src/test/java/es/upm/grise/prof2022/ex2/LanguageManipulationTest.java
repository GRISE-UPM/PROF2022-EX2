package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class LanguageManipulationTest {

	@Test
	public void path1() throws Exception {
		LanguageManipulation lm = new LanguageManipulation();
		AccesoFicheros af = new AccesoFicheros();
		assertThrows(CannotFindPropertyFileOrWrongFileException.class, () -> lm.getText("greeting", Language.Italian,af));
	}
	@Test
	public void path2() throws Exception {
		LanguageManipulation lm = new LanguageManipulation();
		AccesoFicheros af = new AccesoFicheros();
		assertEquals("How are you?", lm.getText("greeting", Language.English,af));
	}
	@Test
	public void path3() throws Exception {
		LanguageManipulation lm = new LanguageManipulation();
		AccesoFicheros af = new AccesoFicheros();
		assertEquals("This Key does not exist or it has not been yet translated", lm.getText("tude mal?", Language.Spanish,af));
	}
}
