/*
 * 
 * @AngestellterAnlegen.java 03 13.06.2017 (Robert Lorenz)
 * 
 * Copyright (c) 2017 Lehrprofessur für Informatik, Universität Augsburg
 * 
 */

package kapitel10.gui;

import kapitel10.data.*;
import kapitel10.store.*;

import java.sql.*;
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
import java.text.DateFormat;
import java.util.Date;
import java.text.ParseException;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

public class AngestelltenAnlegen extends Dialog implements ActionListener {

	private Angestellter subject;
	private AngestellterContainer container;

	private TextField nummerTextfeld;
	private TextField nameTextfeld;
	private TextField beginnTextfeld;
	private TextField vorgesetzterTextfeld;
	
	private Button vorgesetzterButton;

	public AngestelltenAnlegen(AngestelltenverwaltungGUI f) {

		super(f, "Neuen Angestellten anlegen", false);

		this.setLayout(new GridLayout(0, 1));

		Panel oben = new Panel();
		add(oben);
		oben.setLayout(new BorderLayout());

		Panel p = new Panel();
		oben.add(p, BorderLayout.NORTH);
		Label nummerLabel = new Label("Nummer: ");
		nummerTextfeld = new TextField(20);
		p.add(nummerLabel);
		p.add(nummerTextfeld);

		Label nameLabel = new Label("Name: ");
		nameTextfeld = new TextField(20);
		p.add(nameLabel);
		p.add(nameTextfeld);

		Label beginnLabel = new Label("Beginn: ");
		beginnTextfeld = new TextField(20);
		p.add(beginnLabel);
		p.add(beginnTextfeld);

		Label vorgesetzterLabel = new Label("Vorgesetzter: ");
		vorgesetzterButton = new Button("Neuer Vorgesetzter");
		vorgesetzterButton.addActionListener(e -> {
			subject = new AngestelltenAuswahl(this).getAuswahl();
			if (subject == null) {
				vorgesetzterTextfeld.setText(String.valueOf(subject.getNummer());
				subject = null;
			} else {
				new WarnDialog(this, "Kein Angestellter ausgewählt");
			}
		});
		vorgesetzterTextfeld = new TextField(20);
		vorgesetzterTextfeld.setEnabled(false);
		p.add(vorgesetzterLabel);
		p.add(vorgesetzterTextfeld);
		p.add(vorgesetzterButton);
		

		Panel t = new Panel();
		oben.add(t, BorderLayout.CENTER);

		Button ok = new Button("Ok");
		ok.addActionListener(this);
		t.add(ok);
		Button uebernehmen = new Button("Übernehmen");
		uebernehmen.addActionListener(this);
		t.add(uebernehmen);
		Button abbrechen = new Button("Abbrechen");
		abbrechen.addActionListener(this);
		t.add(abbrechen);
		Button liste = new Button("Angestelltenliste");
		liste.addActionListener(this);
		t.add(liste);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		setLocation(f.getLocation().x + 200, f.getLocation().y + 200);

		try {
		    	container = AngestellterContainer.instance();
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

	private void save() {
		try {
			int nummer = Integer.parseInt(nummerTextfeld.getText());
			Date beginnDate = DateFormat.getDateInstance().parse(
					beginnTextfeld.getText());
			subject = new Angestellter(nummer,nameTextfeld.getText(), beginnDate);
			if (!vorgesetzterTextfeld.getText().equals("")) {
			    int vorgesetzternummer = Integer.parseInt(vorgesetzterTextfeld.getText());
			    Angestellter vorgesetzter = container.searchAngestellter(vorgesetzternummer);
			    subject.linkVorgesetzter(vorgesetzter);
			}
			container.linkAngestellter(subject);
			clear();
			subject = null;
		} 
		catch (NumberFormatException e) {
			new Warndialog(this, "Nummer nicht korrekt" + e.getMessage());
		}
		catch (ParseException e) {
			new Warndialog(this, "Datum nicht korrekt" + e.getMessage());
		}
		catch (SQLException e) {
			   new Warndialog(this, "Datenbankfehler: " + e.getMessage());
		}
		catch(IllegalInputException e) {
			   new Warndialog(this, "Angestellter konnte nicht angelegt werden: " + e.getMessage());
		}
	}

	private void clear() {
		nummerTextfeld.setText("");
		nameTextfeld.setText("");
		beginnTextfeld.setText("");
		vorgesetzterTextfeld.setText("");
	}

	public void actionPerformed (ActionEvent e) {
		if (e.getActionCommand().equals("Ok")) {
			onOk();
		}
		else if (e.getActionCommand().equals("Übernehmen")) {
			onUebernehmen();
		}
		else if (e.getActionCommand().equals("Abbrechen")) {
			onAbbrechen();
		}
		else if (e.getActionCommand().equals("Angestelltenliste")) {
			onListe();
		}
	}
	
	private void onOk() {
		save();
		onAbbrechen();
	}
	
	private void onUebernehmen() {
		save();
	}
	
	private void onAbbrechen() {
		dispose();
	}
	
	private void onListe() {
		AngestelltenAuswahl auswahl = new AngestelltenAuswahl(this);
		subject = auswahl.getAuswahl();
		load();
	}
	
	private void load () {
		if (subject != null) {
			nummerTextfeld.setText(subject.getNummer()+"");
			nameTextfeld.setText(subject.getName());
			beginnTextfeld.setText(DateFormat.getDateInstance().format(
					subject.getBeginn()));
			if (subject.getlinkVorgesetzter() != null)
			    vorgesetzterTextfeld.setText(subject.getlinkVorgesetzter().getNummer() + "");
			else
			    vorgesetzterTextfeld.setText("");  
			subject = null;
		}
		else {
			new Warndialog(this, "Kein Angestellter ausgewählt");
		}
	}
}
