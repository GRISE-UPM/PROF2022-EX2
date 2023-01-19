package es.upm.grise.prof2022.ex2;
import java.util.Properties;
import java.io.FileInputStream;
public class Access {
private String resource = "resource/";
private Properties propertyFile;
	public Access() {}
	public Access(String resource) {
		this.resource = resource;
	}
	public String getString(String resource, String key) throws Exception {
		propertyFile = new Properties();
		propertyFile.load(new FileInputStream(resource+ resource));

		return propertyFile.getProperty(key);

	}


}