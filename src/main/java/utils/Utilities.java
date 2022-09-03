package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Utilities {
	
	/**
	 * @param key: config key
	 * @return String, value of the key associated in properties file
	 */
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
	
	/**
	 * @param listOfStrings : String List to check sorted or not
	 * @return Boolean, True if it is sorted, False if it is not sorted
	 */
	public static boolean isSorted(List<String> listOfStrings) {
	    
	    boolean isSorted=true;
        for(int i=1;i < listOfStrings.size();i++){
            if(listOfStrings.get(i-1).compareTo(listOfStrings.get(i)) > 0){
                isSorted= false;
                break;
            }
        }
        return isSorted;  
	}
	
}
