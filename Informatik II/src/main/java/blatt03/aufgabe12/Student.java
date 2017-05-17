package blatt03.aufgabe12;

import java.util.ArrayList;
import java.util.List;

public class Student {

	private final List<String> email = new ArrayList<>();
	
	public void addEmail(final String email) {
		if (email == null) {
			throw new IllegalArgumentException("email == null");
		}
		if (!checkEmail(email)) {
			throw new IllegalArgumentException("invalid email");
		}
		this.email.add(email);
	}
	
	public void deleteEmail(final String email) {
		if (email == null) {
			throw new IllegalArgumentException("email == null");
		}
		this.email.remove(email);
	}
	
	public List<String> getEmail() {
		return email;
	}
	
	public String getEmail(final int p) {
		return email.get(p);
	}
	
	private static boolean checkEmail(final String email) {
		return email.matches("\\b@\\b");
	}
}
