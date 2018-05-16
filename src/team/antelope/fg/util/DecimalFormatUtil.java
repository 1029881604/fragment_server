package team.antelope.fg.util;

import java.text.DecimalFormat;

public class DecimalFormatUtil {
	private static DecimalFormat format = new DecimalFormat("#.0"); 
	
	public static String formatPoint1(Double db){
		format.applyPattern("#.0");
		return format.format(db);
	}
	
	public static String formatPoint2(Double db){
		format.applyPattern("#.00");
		return format.format(db);
	}
	
}
