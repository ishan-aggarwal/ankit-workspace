package abhimanyu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
		Password val = (password) -> {

			System.out.println(password);

			String regex = "^(?=.*[0-9])"
					+ "(?=.[a-z])(?=.[A-Z])"
					+ "(?=.*[@#$%^&+=])"
					+ "(?=\\S+$).{6,16}$";

			Pattern p = Pattern.compile(regex);

			if (password == null) {
				return false;
			}

			Matcher m = p.matcher(password);

			return m.matches();
		};
		System.out.println(val.isValid("Hello@123"));

	}
}