package blatt1.aufgabe4;

public class Aufgabe4a {

	private static final int e = 10;

	public static void main(String[] args) {
		System.out.println("Ergebnis: " + factorial(e));
	}

	/**
	 * Returns n!, that is, the product of the first {@code n} positive
	 * integers, {@code 1} if {@code n == 0}, or {@link Integer#MAX_VALUE} if
	 * the result does not fit in a {@code int}.
	 * 
	 * @param n
	 *            - the number whose factorial should be returned
	 * @return the factorial of the number passed as argument
	 * @throws IllegalArgumentException
	 *             if n is < 0
	 */
	public static int factorial(final int n) {
		if (n < 0) {
			throw new IllegalArgumentException("n (" + n +") must be >= 0");
		}
		if (n > 12) {
//			13! is 6.2227.020.800 which is greater than Integer.MAX_VALUE (2.147.483.647)
			return Integer.MAX_VALUE;
		}
		if (n == 0) {
			return 1;
		}
		if (n <= 2) {
			return n;
		}
		int result = 6;
		for (int i = 4; i <= n; i++) {
			result *= i;
		}
		return result;
	}
}
