package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

public class LanguageManipulationTest {

	LanguageManipulation testedClass = new LanguageManipulation();
	@Test
	public void nonExistingKeyExceptionTest() { // Corresponde al primer if
		Assertions.assertThrows(NonExistingKeyException.class , () -> testedClass.getText("noKey",Language.English));
	}

	@Test
	public void nonExistingKeySpanishTest() throws Exception { // Corresponde al segundo if
		Assertions.assertEquals("This Key does not exist or it has not been yet translated" , testedClass.getText("noKey",Language.Spanish));
	}


}
