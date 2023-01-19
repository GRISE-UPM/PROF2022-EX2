package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class LanguageManipulationTest {
	
	@Test
	public void property_file_error_test() throws Exception{
		LanguageManipulationCollab lmc = mock(LanguageManipulationCollab.class);
		when(lmc.getText(null,Language.Italian)).thenThrow(CannotFindPropertyFileOrWrongFileException.class);
		assertThrows(CannotFindPropertyFileOrWrongFileException.class,()->lmc.getText(null,Language.Italian));
	}

	@Test
	public void null_text_and_english_language_test() throws Exception{
		LanguageManipulationCollab lmc = mock(LanguageManipulationCollab.class);
		when(lmc.getText("no_property",Language.English)).thenThrow(NonExistingKeyException.class);
		assertThrows(NonExistingKeyException.class,()->lmc.getText("no_property",Language.English));
	}

	@Test
	public void text_and_spanish_languge_test() throws Exception{
		LanguageManipulationCollab lmc = mock(LanguageManipulationCollab.class);
		when(lmc.getText("no_property",Language.Spanish)).thenReturn("This Key does not exist or it has not been yet translated");
		assertEquals("This Key does not exist or it has not been yet translated",lmc.getText("no_property",Language.Spanish));
	}

}
