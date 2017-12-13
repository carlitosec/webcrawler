package com.cc.webcrawler.util;

/**
 * @author ccarrillo
 *
 */
public class StringUtil {

	public static Integer getOrderValue(String order) {
		String s = order.replace(".", "");
		return Integer.parseInt(s);
	}
	
	public static Integer getNumberWords(String title) {
		return title.split("\\s+").length;
	}
	
	public static Integer getNumber(String text) {
		try {
			return Integer.parseInt(text.split("\\s+")[0]);
		} catch (NumberFormatException e) {
			
			try {
				int index = text.indexOf(" ");
				if (index != -1) {
					return Integer.parseInt(text.substring(0, index));
				}
				
			} catch (NumberFormatException nfe) {
				return 0;
			}
			
			return 0;
		}
		
	}
	
//	public static void main(String[] args) {
//		System.out.println(getNumberWords("NASA to test prototype Kilopower nuclear"));
//		System.out.println(getNumberWords("The Mathematics of 2048"));
//	}
	
}
