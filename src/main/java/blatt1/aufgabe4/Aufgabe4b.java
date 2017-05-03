package blatt1.aufgabe4;

public class Aufgabe4b {

	private static final int NUM = 99;

	public static void main(String[] args) {
		System.out.println("Ergebnis: " + binaryCount(NUM));
	}

	/**
	 * Returns the amount of digits needed to represent the number in binary
	 * 
	 * @param num - the number
	 * @return the amount of digits needed to represent this number in binary
	 */
	public static int binaryCount(final int num) {
		return Integer.toBinaryString(num).length();
	}
}
