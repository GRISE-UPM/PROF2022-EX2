package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class LanguageManipulationTest {

	@Test
	public void smokeTest() throws Exception {
		LanguageManipulation lm = new LanguageManipulation();
		assertEquals("How are you?", lm.getText("greeting", Language.English));
		assertEquals("¿Cómo se encuentra?", lm.getText("greeting", Language.Spanish));
		assertThrows(CannotFindPropertyFileOrWrongFileException.class, () -> lm.getText("greeting", Language.Italian));
	}

}
