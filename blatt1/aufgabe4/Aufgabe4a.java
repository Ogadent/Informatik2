package blatt1.aufgabe4;

public class Aufgabe4a {

	private static final int e = 10;
	
	public static void main(String[] args) {
		System.out.println("Ergebnis: " + fakulty(e));
	}
	
	public static int fakulty(final int num) {
		if (num <= 2 && num >= 0) {
			return num;
		}
		if (num < 0) {
			throw new IllegalArgumentException("num must be >= 0");
		}
		int result = 6;
		for (int i = 4; i <= num; i++) {
			result *= i;
		}
		return result;
	}
}
