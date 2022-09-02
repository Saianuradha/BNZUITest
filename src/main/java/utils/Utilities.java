package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
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
	
	public static boolean isSorted(List<String> listOfStrings) {
//	    if (listOfStrings.size() == 0 || listOfStrings.size() == 1) {
//	        return true;
//	    }
//
//	    Iterator<String> iter = listOfStrings.iterator();
//	    String current, previous = iter.next();
//	    while (iter.hasNext()) {
//	        current = iter.next();
//	        if (previous.compareTo(current) > 0) {
//	            return false;
//	        }
//	        previous = current;
//	    }
//	    return true;
	    
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
