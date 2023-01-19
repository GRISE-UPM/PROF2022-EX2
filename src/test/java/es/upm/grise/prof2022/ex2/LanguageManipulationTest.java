package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LanguageManipulationTest {

	static Collaborator collaborator;
	static LanguageManipulation lm;
	static String key = "farewell";
	static String text = "This Key does not exist or it has not been yet translated";

	@BeforeAll
	static void setUp() {
		collaborator = mock(Collaborator.class);

		lm = new LanguageManipulation();
		lm.setCollaborator(collaborator);
	}

	/*
	 * C2: 15,18,19 - 24 - 26 - 43
	 */
	@Test
	public void catchTest() {
		LanguageManipulation lm = new LanguageManipulation();
		assertThrows(CannotFindPropertyFileOrWrongFileException.class,
				() -> lm.getText("greeting", Language.Italian));
	}

	/*
	 * C6: 15,18,19 - 24 - 30 - 33a - 33b - 34 - 43
	 */
	@Test
	public void firstIfTest() {
		when(collaborator.getProperty(key)).thenReturn(null);
		assertThrows(NonExistingKeyException.class, () -> lm.getText(key, Language.English));
	}

	/*
	 * C8: 15,18,19 - 24 - 30 - 33a - 38a - 38b - 39 - 42 - 43
	 */
	@Test
	public void secondIfTest() throws Exception {
		when(collaborator.getProperty(key)).thenReturn(text);
		assertEquals(text, lm.getText(key, Language.Spanish));
	}
}
