package es.upm.grise.prof2022.ex2;

import java.io.FileInputStream;
import java.util.Properties;

public class LanguageManipulationCollab {
    
    private Properties propertyFile;

    public LanguageManipulationCollab(){
        this.propertyFile = new Properties();
    }

    public String getText(String key,Language lan) throws Exception{
        String filename = lan.toString() + "-strings.properties";
        try {
			propertyFile.load(new FileInputStream("resources/" + filename));
		} catch (Exception e) {
			throw new CannotFindPropertyFileOrWrongFileException();
		}

        String text = propertyFile.getProperty(key);

        if(text == null && lan == Language.English) { 
			throw new NonExistingKeyException();
		}

        if(text == null && lan != Language.English) { 
			text = "This Key does not exist or it has not been yet translated";
		}

        return text;
    }
    


}
