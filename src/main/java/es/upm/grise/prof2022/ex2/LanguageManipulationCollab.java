public class LanguageManipulationCollab {
    
    private Properties propertyFile;

    public LanguageManipulationCollab(){
        this.propertyFile = new Properties();
    }

    public String getText(String key,Language lan) throws Exception{
        String filename = lan.toString() + "-strings.properties";
        try {
			propertyFile.load(new FileInputStream("resources/" + fileName));
		} catch (Exception e) {
			throw new CannotFindPropertyFileOrWrongFileException();
		}

        String text = propertyFile.getProperty(key);

        if(text == null && language == Language.English) { 
			throw new NonExistingKeyException();
		}

        if(text == null && language != Language.English) { 
			text = "This Key does not exist or it has not been yet translated";
		}

        return text;
    }
    


}
