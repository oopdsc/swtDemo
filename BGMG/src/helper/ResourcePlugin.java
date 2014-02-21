package helper;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourcePlugin {
	
	private static ResourceBundle rb;
	
	static {
		rb = ResourceBundle.getBundle("msg", Locale.SIMPLIFIED_CHINESE);
	}
	
	public static  String getProperty(String arg0){
		if(rb.containsKey(arg0)){
			return rb.getString(arg0);
		}else{
			return "";
		}
	}

}
