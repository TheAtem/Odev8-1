package kodlamaio.hrms.core.results;

import java.util.regex.Pattern;


public class Validation {
	
	private static Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
	
	public static boolean email(String email) {
		return pattern.matcher(email).matches();
	}

	public static boolean email(String email, String regex) {
		String regexEmail = "^[A-Za-z0-9+_.-]+@" + regex;
		Pattern pattern = Pattern.compile(regexEmail);
		if(email.contains(regex)) {
			return pattern.matcher(email).matches();
		}else {
			return false;
		}
	}
	
	public static boolean identityNumber(String identityNumber) {
		
		if(identityNumber.toCharArray().length == 11) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean hrmsPersonel() {
		return true;
	}
		
}
