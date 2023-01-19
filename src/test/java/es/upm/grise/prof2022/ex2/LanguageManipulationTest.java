package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class LanguageManipulationTest {

	
	@Test
	//Primer catch
	//Corresponde a mi path: 1-2-FIN
	public void primerCatch() throws Exception {
		LanguageManipulation lm = new LanguageManipulation();
		assertThrows(CannotFindPropertyFileOrWrongFileException.class, () -> lm.getText("greeting", Language.Italian));
	} 
	
	@Test
	//Primer if
	//Corresponde a mi path: 1-3a-3b-5-FIN
	public void TextNull_AND_English() throws Exception {
		LanguageManipulation lm = new LanguageManipulation();
		assertThrows(NonExistingKeyException.class, () -> lm.getText("", Language.English));
	} 
	
	@Test
	//Segundo if
	//Corresponde a mi path: 1-3a-3b-4a-4b-7-6-FIN
	public void TextNull_AND_Not_English() throws Exception {
		LanguageManipulation lm = new LanguageManipulation();
		assertEquals("This Key does not exist or it has not been yet translated", lm.getText("",Language.Spanish ));
		
	} 


}
