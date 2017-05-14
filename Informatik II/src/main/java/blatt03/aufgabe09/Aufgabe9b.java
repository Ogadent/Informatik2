package blatt03.aufgabe09;

import java.util.Arrays;

public class Aufgabe9b {

	public static void main(String[] args) {
		args = new String[]{"Max", "01.02.2100", "0112", null};
		if (args.length < 1) {
			return;
		}
		final Contact contact = new Contact(args[0]);
		if (args.length == 1) {
			return;
		}
		contact.setBirthday(args[1]);
		Arrays.stream(args).forEach(contact::addTelephone);
//		add if check?
		contact.deleteTelephone("0112");
		contact.getTelephone().forEach(System.out::println);
	}
}
