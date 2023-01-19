package es.upm.grise.prof2022.ex2;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AccesoPropertyFile {
	public Properties load(String camino) throws IOException{
		Properties propiedades = new Properties();
		FileInputStream cargar_Camino = new FileInputStream(camino);
		propiedades.load(cargar_Camino);
		return propiedades;
	}
}
