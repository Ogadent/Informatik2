package blatt08;

/*
 * 
 * @Angestellter.java 02 13.06.2017 (Robert Lorenz)
 * 
 * Copyright (c) 2017 Lehrprofessur fÃ¼r Informatik, UniversitÃ¤t Augsburg
 * 
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Angestellter extends Observable {

	private int nummer;
	private String name;
	private Date beginn;
	private Angestellter vorgesetzter;
	
	public Angestellter(int nummer, String name, Date beginn) throws IllegalInputException {
		setNummer(nummer);
		setName(name);
		setBeginn(beginn);
		vorgesetzter = null;
	}
	
	 public void setNummer(int nummer) throws IllegalInputException {
		if(nummer > 1000) {
			this.nummer = nummer;
			setChanged();
			notifyObservers();
		}
		else
			throw new IllegalInputException("Nummer muss größer als 1000 sein", ""+nummer);
	}
		
	public int getNummer(){
		return nummer;
	}
	
	public void setName(String name) throws IllegalInputException {
		if (name.length() >= 2 && Character.isUpperCase(name.charAt(0))) {
			this.name = name;
		}
		else
			throw new IllegalInputException("Name muss mindestens 2 "
					+ "Buchstaben haben und mit einem Großbuchstaben beginnen",
					name);
	}

	public void setBeginn(Date beginn) throws IllegalInputException {
		try {
			Date anfang = DateFormat.getDateInstance().parse("1.1.1900");
			if (beginn.after(anfang)) {
				this.beginn = beginn;
			}
			else
				throw new IllegalInputException("Das Datum darf nicht in vor dem 1.1.1900 liegen",beginn.toString());
		}
		catch(ParseException e) {
			throw new IllegalInputException("Fehler beim Setzen des Datums",e.getMessage());
		}
	}

	public String getName() {
		return name;
	}

	public Date getBeginn() {
		return beginn;
	}

	public void linkVorgesetzter(Angestellter vorgesetzter) throws IllegalInputException  {
		if (vorgesetzter == null) 
			throw new IllegalInputException("Null Übergeben","null");
		if (vorgesetzter.equals(this.vorgesetzter)) 
			return;
		if (!this.checkVorgesetzterZyklus(vorgesetzter)) 
			throw new IllegalInputException("Zyklische Vorgesetzten-Beziehung",vorgesetzter.toString());
		this.vorgesetzter = vorgesetzter; 
	}

	public void unlinkVorgesetzter() {
		this.vorgesetzter = null;
	}

	public Angestellter getlinkVorgesetzter() {
		return this.vorgesetzter;
	}

	private boolean checkVorgesetzterZyklus(Angestellter newVorgesetzter) {
		if (newVorgesetzter.equals(this)) {
			return false;
		} else if (newVorgesetzter.vorgesetzter == null) {
			return true;
		} else {
			return this.checkVorgesetzterZyklus(newVorgesetzter.vorgesetzter);
		}
	}

	public boolean equals(Object o){
		if (o == null) 
			return false;
		if (!(o.getClass().equals(this.getClass())))//Überprüfung der Klassen-Zugehörigkeit des Objekts
			return false;
		Angestellter a = (Angestellter) o;
		return (a.getNummer() == this.getNummer());
	}

	public String toString(){
		return "Angestellter " + getNummer() + ": " + getName() + ", ab " + DateFormat.getDateInstance().format(getBeginn());
	}
}
