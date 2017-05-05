package blatt2.aufgabe8;

public class Square {

	private int height;
	private int width;

	public Square(final int height, final int width) {
		setHeight(height);
		setWidth(width);
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(final int height) {
		if (!checkPositive(height)) {
			throw new IllegalArgumentException("height (" + width + ") must be > 0");
		}
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(final int width) {
		if (!checkPositive(width)) {
			throw new IllegalArgumentException("width (" + width + ") must be > 0");
		}
		this.width = width;
	}

	public boolean checkPositive(final int num) {
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
		result = prime * result + height;
		result = prime * result + width;
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
		if (height != other.height) {
			return false;
		}
		if (width != other.width) {
			return false;
		}
		return true;
	}
}
