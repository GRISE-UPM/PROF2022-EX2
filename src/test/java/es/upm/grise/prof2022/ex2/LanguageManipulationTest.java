package es.upm.grise.prof2022.ex2;

import static org.junit.Assert.*;

import org.junit.Test;

public class LanguageManipulationTest {

	@Test
	public void smokeTest() throws Exception {
		LanguageManipulation lm = new LanguageManipulation();
		assertEquals("How are you?", lm.translate("greeting", Language.English));
		assertEquals("¿Cómo se encuentra?", lm.translate("greeting", Language.Spanish));
	}

}
