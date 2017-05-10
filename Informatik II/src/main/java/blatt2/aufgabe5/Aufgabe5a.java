package blatt2.aufgabe5;

public class Aufgabe5a {

	public static void main(String[] args) {
		if (args.length != 1) {
			return;
		}
		final String s = args[0];
		try {
			System.out.println("Das erste Zeichen von " + '"' + s + '"' + " ist " + (Character.isUpperCase(s.charAt(0)) ? "" : "k") + "ein Großbuchstabe.");
			System.out.println('"' + s + '"' + " ist " + (s.length() > 10 ? "länger als" : "maximal") + " 10 Zeichen lang.");
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());	
		}
	}
}
