package blatt2.aufgabe6;

public class Aufgabe6a {

	public static void main(String[] args) {
		if (args.length != 1) {
			return;
		}
		final int arg = Integer.parseInt(args[0]);
		final Integer n = Integer.valueOf(arg);
		System.out.println(n);
		System.out.println(Integer.MAX_VALUE);
	}
}
