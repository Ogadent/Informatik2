package blatt03.aufgabe12;

public class Point {

	private int x;
	private int y;
	
	public Point(final int x, final int y) {
		setX(x);
		setY(y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		if (!checkX(x)) {
			throw new IllegalArgumentException("x (" + x + ") must be >= 0");
		}
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		if (!checkY(y)) {
			throw new IllegalArgumentException("y (" + y + ") must be >= 0");
		}
		this.y = y;
	}
	
	private static boolean checkX(final int x) {
		return x >= 0;
	}
	
	private static boolean checkY(final int y) {
		return y >= 0;
	}
}
