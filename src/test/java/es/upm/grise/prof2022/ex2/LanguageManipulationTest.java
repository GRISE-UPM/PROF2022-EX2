package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class LanguageManipulationTest {


	
	@Test
	//Primer catch
	//Corresponde a mi path: 1-2-FIN
	public void primerCatch() throws Exception {
		Colaborador c = mock(Colaborador.class);
		LanguageManipulation lm = new LanguageManipulation();
		when(c.getProperty("Hello")).thenThrow(new CannotFindPropertyFileOrWrongFileException());
		assertThrows(CannotFindPropertyFileOrWrongFileException.class, () -> lm.getText("Hello", Language.Italian,c));
	} 
	
	@Test
	//Primer if
	//Corresponde a mi path: 1-3a-3b-5-FIN
	public void TextNull_AND_English() throws Exception {
		Colaborador c = mock(Colaborador.class);
		when(c.getProperty("Hello")).thenReturn(null);
		LanguageManipulation lm = new LanguageManipulation();
		assertThrows(NonExistingKeyException.class, () -> lm.getText("Hello", Language.English, c));
	} 
	
	@Test
	//Segundo if
	//Corresponde a mi path: 1-3a-3b-4a-4b-7-6-FIN
	public void TextNull_AND_Not_English() throws Exception {
		Colaborador c = mock(Colaborador.class);
		LanguageManipulation lm = new LanguageManipulation();
		when(c.getProperty("Hello")).thenReturn(null);
		assertEquals("This Key does not exist or it has not been yet translated", lm.getText("Hello",Language.Spanish,c ));
		
	} 


}
