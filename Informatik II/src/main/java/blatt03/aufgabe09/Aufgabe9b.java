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
		Arrays.stream(args).forEach(contact::addTelephone);
		contact.deleteTelephone("0112");
		contact.getTelephone().forEach(System.out::println);
	}
}
