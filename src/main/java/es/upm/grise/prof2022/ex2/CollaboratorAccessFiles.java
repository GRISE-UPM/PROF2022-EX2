package es.upm.grise.prof2022.ex2;

import java.io.FileInputStream;
import java.util.Properties;

//Esta clase cumplirá las funciones de carga y acceso al fichero para así liberar
// a LanguageManipulation de esto
public class CollaboratorAccessFiles {

	 private Properties propertyFile = new Properties();
     private String fileName;

	    public void loadFile(Language language) throws Exception {
	    	fileName = language.toString() + "-strings.properties";
	        propertyFile.load(new FileInputStream("resources/" + fileName));
	    }

	    public String getProperty(String key) throws Exception {
	        return propertyFile.getProperty(key);
	    }


}
