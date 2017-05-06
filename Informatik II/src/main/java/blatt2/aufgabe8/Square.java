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

	@Override
	public String toString() {
		return "Square [height=" + height + ", width=" + width + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(width);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Square other = (Square) obj;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height)) {
			return false;
		}
		if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width)) {
			return false;
		}
		return true;
	}
}
