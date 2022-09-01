package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utilities {
	public static String getConfigValue(String key){
		Properties config = new Properties();
		String fileName = "";
		if(System.getProperty("os.name").contains("win")){
			fileName = "properties\\config.properties";
		}
		else{
			fileName = "properties/configuration.properties";
		}
		InputStream is = Utilities.class.getClassLoader().getResourceAsStream(fileName);
		try {
			config.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return config.getProperty(key);
	}
}
