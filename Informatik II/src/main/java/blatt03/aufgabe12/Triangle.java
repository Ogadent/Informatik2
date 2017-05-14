package blatt03.aufgabe12;

import blatt03.aufgabe09.Point;

public class Triangle {

	private Point[] angle;
	
	public Triangle(final Point angle1, final Point angle2, final Point angle3) {
		angle = new Point[]{angle1, angle2, angle3};
	}
	
	public Point getAngle(final int p) {
		if (p < 0 || p > 2) {
			throw new IndexOutOfBoundsException("p must be between (inclusive) 0 and 2");
		}
		return angle[p];
	}
	
	public void setAngle(final int p, final Point angle) {
		if (p < 0 || p > 2) {
			throw new IndexOutOfBoundsException("p must be between (inclusive) 0 and 2");
		}
		this.angle[p] = angle;
	}
}
