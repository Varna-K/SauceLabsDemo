package utility;


import java.io.FileReader;
import java.util.Properties;

public class ConfigReader {
	private Properties prop=new Properties();
	
	public ConfigReader() {
		FileReader fr;
		try {
			fr = new FileReader("src/main/resources/configProperties.properties");
			prop.load(fr);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
	
	
	public String getProperty(String keyName) {
		return prop.getProperty(keyName);
	}
}
