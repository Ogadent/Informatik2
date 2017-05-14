/*
 * 
 * @Circle.java 02 07.05.2017 (Robert Lorenz)
 * 
 * Copyright (c) 2017 Lehrprofessur für Informatik, Universität Augsburg
 * 
 */

package blatt03.aufgabe09;

/**
 * Durch seinen Radius spezifizierter Kreis
 * 
 * @author lorenzro
 */
public class Circle {

	private double radius;
	private Point position;
	private static int count = 0;

	/**
	 * Erzeugt einen neuen Kreis mit übergebenem Radius
	 * 
	 * @param radius
	 *            übergebener Radius
	 * @throws IllegalArgumentException falls ungültige Daten übergeben wurden
	 */
	public Circle(double radius, Point position) throws IllegalArgumentException {
		this.setRadius(radius);
		this.setPosition(position);
		++count;
	}

	/**
	 * Gibt die Anzahl aller erzeugten Circle-Objkete zurück
	 * 
	 * @return count Anzahl aller erzeugten Circle-Objkete
	 */
	public static int getCount() {
		return count;
	}

	/**
	 * Gibt den Radius zurück
	 * 
	 * @return Radius des Kreises
	 */
	public double getRadius() {
		return this.radius;
	}

	/**
	 * Gibt die Position zurück
	 * 
	 * @return Position des Kreises
	 */
	public Point getPosition() {
		return this.position;
	}

	private static boolean checkRadius(double radius) {
		return (radius > 0);
	}

	/**
	 * Setzt den Radius, falls ein gültiger Wert übergeben wird. Gültig sind
	 * positive Zahlen.
	 * 
	 * @param radius
	 *            Radius
	 * @throws IllegalArgumentException falls ungültige Daten übergeben wurden
	 */
	public void setRadius(double radius) throws IllegalArgumentException {
		if (!checkRadius(radius))
			throw new IllegalArgumentException("Radius ungueltig");
		this.radius = radius;
	}

	private static boolean checkPosition(Point position) {
		return true;
	}

	/**
	 * Setzt die Position, falls ein gültiger Wert übergeben wird. Gültig sind
	 * beliebige Punkte.
	 * 
	 * @param position
	 *            Position
	 * @throws IllegalArgumentException falls ungültige Daten übergeben wurden
	 */
	public void setPosition(Point position) throws IllegalArgumentException {
		if (!checkPosition(position))
			throw new IllegalArgumentException("Position ungueltig");
		this.position = position;
	}

	/**
	 * Berechnet die Fläche des Kreises
	 * 
	 * @return Kreisflaeche
	 */
	public double getArea() {
		return Math.PI * this.radius * this.radius;
	}

}
