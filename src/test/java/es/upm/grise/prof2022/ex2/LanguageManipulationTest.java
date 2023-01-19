package es.upm.grise.prof2022.ex2;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Properties;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


public class LanguageManipulationTest {


	@Test
	public void testFirstCatch() throws IOException {
		LanguageManipulation lm = new LanguageManipulation();
		// A constructor and feeding the mockould be cleaner I guess but since this is code that is given I wanna touch it the least amount possible
		lm.propertyFileAccessor = Mockito.mock(PropertyFileAccessor.class);

		when(lm.propertyFileAccessor.load(anyString())).thenThrow(new IOException());

		CannotFindPropertyFileOrWrongFileException e = Assert.assertThrows("Unexisting Language", CannotFindPropertyFileOrWrongFileException.class, () -> lm.getText("aaaa", Language.Italian)); // Italian language not given
		// We would check e here if we did anything with it

	}


	@Test
	public void testFirstIf() throws IOException {
		LanguageManipulation lm = new LanguageManipulation();
		// A constructor and feeding the mockould be cleaner I guess but since this is code that is given I wanna touch it the least amount possible
		lm.propertyFileAccessor = Mockito.mock(PropertyFileAccessor.class);

		when(lm.propertyFileAccessor.load(anyString())).thenReturn(new Properties());
		when(lm.propertyFileAccessor.getProperty(anyString())).thenReturn(null);

		NonExistingKeyException e = Assert.assertThrows("English Language", NonExistingKeyException.class, () -> lm.getText("aaaa", Language.English)); // Non existing key English case
		// We would check e here if we did anything with it

	}

	@Test
	public void testSecondIf() throws Exception{
		LanguageManipulation lm = new LanguageManipulation();
		lm.propertyFileAccessor = Mockito.mock(PropertyFileAccessor.class);

		when(lm.propertyFileAccessor.load(anyString())).thenReturn(new Properties());
		when(lm.propertyFileAccessor.getProperty(anyString())).thenReturn(null);

		Assert.assertEquals("This Key does not exist or it has not been yet translated", lm.getText("AAA", Language.Spanish)); // Non existing key in not english

	}

}
