package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class LanguageManipulationTest {

//	@Test
//	public void smokeTest() throws Exception {
//		LanguageManipulation lm = new LanguageManipulation();
//		assertEquals("How are you?", lm.getText("greeting", Language.English));
//		assertEquals("¿Cómo se encuentra?", lm.getText("greeting", Language.Spanish));
//		assertThrows(CannotFindPropertyFileOrWrongFileException.class, () -> lm.getText("greeting", Language.Italian));
//	}
	
	LanguageManipulation lm = new LanguageManipulation();
	
	//Test para poner a prueba el catch
	//El camino que recorre es P6: 15,18,19 - 24 - 26 - 43
	@Test
	public void getTextTest_catch() throws Exception{
		assertThrows(CannotFindPropertyFileOrWrongFileException.class, () -> lm.getText(null, Language.Italian));
	}
	
	//Test para poner a prueba el primer if
	//El camino que recorre es P1: 15,18,19 - 24 - 30 - 33(a) - 33(b) - 34 -43
	@Test
	public void getTextTest_firstIf(){
		assertThrows(NonExistingKeyException.class, () -> lm.getText(null, Language.English));
	}
	
	//Test para poner a prueba el segundo if
	//El camino que recorre es P3: 15,18,19 - 24 - 30 - 33(a) - 38(a) - 38(b) - 39 - 42 - 43
	@Test
	public void getTextTest_secondIf() throws Exception{
		assertEquals("This Key does not exist or it has not been yet translated",
				lm.getText(null, Language.Spanish));
		
	}

}


