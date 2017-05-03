package blatt1.aufgabe3;

public class Aufgabe3d {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Fehler");
			return;
		}
		System.out.println(args[0].replace('.', '-'));
	}
}
