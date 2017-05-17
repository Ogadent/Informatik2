package blatt03.aufgabe09;

import java.util.Arrays;

public class Aufgabe9b {

	public static void main(String[] args) {
		if (args.length < 1) {
			return;
		}
		final Contact contact = new Contact(args[0]);
		if (args.length == 1) {
			return;
		}
		contact.setBirthday(args[1]);
		for (int i = 2; i < args.length; i++) {
			contact.addTelephone(args[i]);
		}
		contact.deleteTelephone("0112");
		contact.getTelephone().forEach(System.out::println);
	}
}
