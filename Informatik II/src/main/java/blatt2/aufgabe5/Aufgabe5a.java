package blatt2.aufgabe5;

public class Aufgabe5a {

	public static void main(String[] args) {
		args = new String[]{"Test"};
		if (args.length != 1) {
			return;
		}
		final String s = args[0];
		System.out.println("Das erste Zeichen von " + '"' + s + '"' + " ist " + (Character.isUpperCase(s.charAt(0)) ? "" : "k") + "ein Großbuchstabe.");
		System.out.println('"' + s + '"' + " ist " + (s.length() > 10 ? "länger" : "maximal") + " 10 Zeichen lang.");
	}
}
