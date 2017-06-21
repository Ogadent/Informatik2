/*
 * 
 * @AngestelltenListe.java 01 13.07.2017 (Robert Lorenz)
 * 
 * Copyright (c) 2017 Lehrprofessur fÃ¼r Informatik, UniversitÃ¤t Augsburg
 * 
 */

package blatt08;

import java.awt.TextField;
import java.awt.TextArea;
import java.awt.List;
import java.awt.Checkbox;
import java.awt.Frame;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.Label;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.text.ParseException;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.Observer;
import java.util.Observable;

public class AngestelltenListe extends Dialog implements ActionListener, Observer {

	private AngestellterContainer container;
	// private Angestellter subject = null;

	private List alleAngestelltenListe;

	public AngestelltenListe(AngestelltenverwaltungGUI f) {

		super(f, "Alle Angestellten anzeigen", false);

		this.setLayout(new GridLayout(0, 1));

		Panel unten = new Panel();
		add(unten);
		unten.setLayout(new BorderLayout());

		Label alleAngestelltenLabel = new Label("Alle Angestellten: ");
		unten.add(alleAngestelltenLabel, BorderLayout.NORTH);

		alleAngestelltenListe = new List();
		unten.add(alleAngestelltenListe, BorderLayout.CENTER);
		alleAngestelltenListe.setEnabled(true);

		Panel s = new Panel();
		unten.add(s, BorderLayout.SOUTH);
		Button loeschen = new Button("Angestellten löschen");
		loeschen.addActionListener(this);
		s.add(loeschen);
		Button abbrechen = new Button("Abbrechen");
		abbrechen.addActionListener(this);
		s.add(abbrechen);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		setLocation(f.getLocation().x + 200, f.getLocation().y + 200);

		try {
			container = AngestellterContainer.instance();
			container.addObserver(this);
			update(container, null);
		} catch (SQLException e) {
			new Warndialog(this, "Datenbankfehler: " + e.getMessage());
			dispose();
		} catch (ClassNotFoundException e) {
			new Warndialog(this, "Datenbankfehler: " + e.getMessage());
			dispose();
		}

		pack();
		setVisible(true);
	}

	public void update(Observable o, Object arg) {
		alleAngestelltenListe.removeAll();
		for (Angestellter a : container) {
			alleAngestelltenListe.add(a.toString());
			a.addObserver(this);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Angestellten löschen")) {
			onLoeschen();
		} else if (e.getActionCommand().equals("Abbrechen")) {
			onAbbrechen();
		}
	}

	private void onLoeschen() {
		String auswahl = alleAngestelltenListe.getSelectedItem();
		if (auswahl != null) {
			Angestellter subject = searchAngestellter(auswahl);
			if (subject == null) {
				new Warndialog(this, "Ausgewählter Angestellter nicht vorhanden");
				return;
			}
			try {
				container.unlinkAngestellter(subject);
			} catch (SQLException e) {
				new Warndialog(this, "Datenbankfehler");
			} catch (IllegalInputException e) {
				new Warndialog(this, "Angestellter konnte nicht gelöscht werden: " + e.getMessage());
			}
		} else {
			new Warndialog(this, "Kein Angestellter ausgewählt");
		}
	}

	private void onAbbrechen() {
		dispose();
	}

	private Angestellter searchAngestellter(String auswahl) {
		for (Angestellter a : container) {
			if (a.toString().equals(auswahl))
				return a;
		}
		return null;
	}
}
