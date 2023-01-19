package es.upm.grise.prof2022.ex2;
import java.io.FileInputStream;
import java.util.Properties;

public class Refactor {

    Properties propertyFile = new Properties();

    // Constructor
    public Refactor(){
    }

    // Carga el fichero de propiedades
    public String cargaryobtener(String key, Language language) throws Exception {
      	
		// Load the property fileException
		// If the file does not exist, we raise an exception
		try {
            String fileName = language.toString() + "-strings.properties";
            propertyFile.load(new FileInputStream("resources/" + fileName));
		} catch (Exception e) {
			throw new CannotFindPropertyFileOrWrongFileException();
		}

		// Find the requested string
		return propertyFile.getProperty(key);
    }
    
}
