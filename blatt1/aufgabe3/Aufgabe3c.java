package blatt1.aufgabe3;

import java.util.Arrays;

public class Aufgabe3c {

	public static void main(String... args) {
		if (args.length == 0) {
			System.err.println("Fehler");
			return;
		}
		System.out.println(Arrays.stream(args).anyMatch(s -> s.contains("a")));
	}
}
