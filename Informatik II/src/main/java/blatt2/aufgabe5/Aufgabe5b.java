package blatt2.aufgabe5;

public class Aufgabe5b {

	public static void main(String[] args) {
		if (args.length != 1) {
			return;
		}
		final StringBuilder s = new StringBuilder(args[0]);
		System.out.println(s.append(s.capacity()));
		System.out.println(s.deleteCharAt(5));
	}
}
