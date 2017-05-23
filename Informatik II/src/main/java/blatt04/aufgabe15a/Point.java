/*
 * 
 * @Point.java 01 07.05.2017 (Robert Lorenz)
 * 
 * Copyright (c) 2017 Lehrprofessur für Informatik, Universität Augsburg
 * 
 */

package blatt04.aufgabe15a;

/**
 * Punkt mit jeweils nicht-negativer ganzzahliger x- und y-Koordinate
 * 
 * @author lorenzro
 *
 */
public class Point {
	
	private int x;
	private int y;
		
	/**
	 * Erzeugt einen Punkt mit den übergebenen x- und y-Koordinaten. 
	 * Gültig sind nicht-negative ganze Zahlen.
	 * 
	 * @param x der Wert der x-Koordinate des erzeugten Punktes
	 * @param y der Wert der y-Koordinate des erzeugten Punktes
	 * 
	 * @throws IllegalArgumentException falls ungültige Daten übergeben wurden
	 */
	public Point(int x, int y) throws IllegalArgumentException {
	    setX(x);
	    setY(y);
	}
		
	private static boolean checkX(int x) {
		return (x >= 0);
	}

	/**
	 * Setzt Wert der x-Koordinate, falls ein gültiger Wert übergeben wird.
	 * Gültig sind nicht-negative ganze Zahlen.
	 * 
	 * @param x der neue Wert der x-Koordinate, falls gültig
	 * 
	 * @throws IllegalArgumentException falls ungültige Daten übergeben wurden
	 */
	public void setX(int x) throws IllegalArgumentException {
		if (!checkX(x))
			throw new IllegalArgumentException("x-Koordinate ungueltig");
		this.x = x;
	}

	private static boolean checkY(int y) {
		return (y >= 0);
	}

	/**
	 * Setzt Wert der y-Koordinate, falls ein gültiger Wert übergeben wird.
	 * Gültig sind nicht-negative ganze Zahlen.
	 * 
	 * @param y der neue Wert der y-Koordinate, falls gültig
	 * 
	 * @throws IllegalArgumentException falls ungültige Daten übergeben wurden
	 */
	public void setY(int y) throws IllegalArgumentException {
		if (!checkY(y))
			throw new IllegalArgumentException("y-Koordinate ungueltig");
		this.y = y;
	}

	
	/**
	 * Gibt Wert der x-Koordinate zurück
	 * 
	 * @return Wert der x-Koordinate
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * Gibt Wert der y-Koordinate zurück
	 * 
	 * @return Wert der y-Koordinate
	 */
	public int getY() {
		return this.y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
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
		Point other = (Point) obj;
		if (x != other.x) {
			return false;
		}
		if (y != other.y) {
			return false;
		}
		return true;
	}
}
