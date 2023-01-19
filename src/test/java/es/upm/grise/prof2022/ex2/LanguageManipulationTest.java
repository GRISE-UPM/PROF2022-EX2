package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LanguageManipulationTest {
  static LanguageManipulation langMan;
  static CollaboratorClass collab;
  

  @BeforeAll
  public static void setUp(){
    collab = new CollaboratorClass();
    langMan = new LanguageManipulation(collab);
  }

  @Test
  public void catchTest(){
    Language lang = Language.Italian;
    String key = "key";
    assertThrows(CannotFindPropertyFileOrWrongFileException.class, () -> {langMan.getText(key, lang);});
  }

  @Test
  public void firstIfTest(){
    Language lang = Language.English;
    String key = "null";
    assertThrows(NonExistingKeyException.class, () -> {langMan.getText(key, lang);});
  }

  @Test
  public void secondIfTest() throws Exception{
    Language lang = Language.Spanish;
    String key = "null";
    assertEquals("This Key does not exist or it has not been yet translated", langMan.getText(key, lang));
  }

}
