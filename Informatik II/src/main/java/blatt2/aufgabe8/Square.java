package blatt2.aufgabe8;

public class Square {

	private double height;
	private double width;

	public Square(final double height, final double width) {
		setHeight(height);
		setWidth(width);
	}
	
	public double getHeight() {
		return height;
	}

	public void setHeight(final double height) {
		if (!checkPositive(height)) {
			throw new IllegalArgumentException("height (" + width + ") must be > 0");
		}
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(final double width) {
		if (!checkPositive(width)) {
			throw new IllegalArgumentException("width (" + width + ") must be > 0");
		}
		this.width = width;
	}

	public boolean checkPositive(final double num) {
		return num > 0;
	}
}
