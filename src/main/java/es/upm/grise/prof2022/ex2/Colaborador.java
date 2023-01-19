package es.upm.grise.prof2022.ex2;

import java.io.FileInputStream;
import java.util.Properties;

public class Colaborador {
	
	protected Properties propertyFile = new Properties();
	public Colaborador( String fileName) throws CannotFindPropertyFileOrWrongFileException  {
		
		try {
			propertyFile.load(new FileInputStream("resources/" + fileName));
		} catch (Exception e) {
			throw new CannotFindPropertyFileOrWrongFileException();
		}

	}


	public String getProperty(String key) {
		propertyFile.getProperty(key);
		return null;
	}

}
