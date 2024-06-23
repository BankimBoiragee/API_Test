package rest.usa.utils;

import org.apache.commons.lang.RandomStringUtils;

public class Rest_Utils2 {
	public static String empName() {
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	public static String empSal() {
		String generatedString=RandomStringUtils.randomNumeric(5);
		return generatedString;
	}
	public static String empAge() {
		String generatedString=RandomStringUtils.randomNumeric(5);
		return generatedString;
	}
}
