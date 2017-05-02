package blatt1.aufgabe3;

public class Aufgabe3b {

	public static void main(String... args) {
		if (args.length != 2) {
			System.err.println("Fehler");
			return;
		}
		System.out.println(args[0].equals(args[1]));
	}
}
