package es.upm.grise.prof2022.ex2;
import java.io.FileInputStream;
import java.util.Properties;

public class Refactor {

    Properties propertyFile = new Properties();

    // Constructor
    public Refactor(){
    }

    // Carga el fichero de propiedades
    public void cargarFichero(Language language) throws Exception {
        String fileName = language.toString() + "-strings.properties";
        propertyFile.load(new FileInputStream("resources/" + fileName));
    }

    // Obtiene la propiedad del fichero de propiedades
    public String obtenerPropiedad(String key) throws Exception {
        return propertyFile.getProperty(key);
    }
    
}
