package es.upm.grise.prof2022.ex2;
import java.util.Properties;
import java.io.FileInputStream;

public class CollaboratorClass {
  Properties propertyFile = new Properties();

  public void loadFile(String fileName) throws CannotFindPropertyFileOrWrongFileException{
    try {
			propertyFile.load(new FileInputStream("resources/" + fileName));
		} catch (Exception e) {
			throw new CannotFindPropertyFileOrWrongFileException();
		}
  }

  public String getString(String key){
    String text = propertyFile.getProperty(key);
    return text;
  }

}
