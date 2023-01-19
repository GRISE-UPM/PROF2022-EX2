package es.upm.grise.prof2022.ex2;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LanguageManipulationTest {

	@Test
	public void test_1() throws Exception {
		
		Language LANGUAGE = Language.Italian;
		String KEY = "Text does not matter because the file does not exist";
		
		PropertyFileIndirection propertyFileIndirectionMock = mock(PropertyFileIndirection.class);
		doThrow(FileNotFoundException.class).when(propertyFileIndirectionMock).loadPropertyFile(any(Language.class));

		LanguageManipulation lm = new LanguageManipulation(propertyFileIndirectionMock);
		assertThrows(CannotFindPropertyFileOrWrongFileException.class, () -> lm.getText(KEY, LANGUAGE));
	}

	@Test
	public void test_2() throws Exception {
		
		Language LANGUAGE = Language.English;
		String KEY = "Non existing key";
		
		PropertyFileIndirection propertyFileIndirectionMock = mock(PropertyFileIndirection.class);
		when(propertyFileIndirectionMock.getRequestedKey(KEY)).thenReturn(null);
		
		LanguageManipulation lm = new LanguageManipulation(propertyFileIndirectionMock);
		assertThrows(NonExistingKeyException.class, () -> lm.getText(KEY, LANGUAGE));
	}
	
	@Test
	public void test_3() throws Exception {
		
		Language LANGUAGE = Language.Spanish;
		String NON_EXISTING_KEY = "";
		String RETURNED_TEXT = "This Key does not exist or it has not been yet translated";
		
		PropertyFileIndirection propertyFileIndirectionMock = mock(PropertyFileIndirection.class);
		when(propertyFileIndirectionMock.getRequestedKey(NON_EXISTING_KEY)).thenReturn(null);
		
		LanguageManipulation lm = new LanguageManipulation(propertyFileIndirectionMock);
		assertEquals(RETURNED_TEXT, lm.getText(NON_EXISTING_KEY, LANGUAGE));
	}

}
