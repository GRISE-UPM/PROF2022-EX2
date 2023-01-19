package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.util.Properties;

public class LanguageManipulationTest {

	// Test del primer catch (P4)
	@Test
	public void TryCatchTest() {
		LanguageManipulation lm = new LanguageManipulation();
		assertThrows(CannotFindPropertyFileOrWrongFileException.class, () -> lm.getText("greeting", Language.Italian));
	}
	// Test del primer if (P2)
	@Test
	public void firstIfTest() throws Exception {
		LanguageManipulation lm = new LanguageManipulation();
		assertThrows(NonExistingKeyException.class, () -> lm.getText("otro", Language.English));
	}

	// Test del segundo if (P1)
	@Test
	public void secondIfTest() throws Exception {
		LanguageManipulation lm = new LanguageManipulation();
		assertEquals("This Key does not exist or it has not been yet translated", lm.getText("otro", Language.Spanish));
	}

}
