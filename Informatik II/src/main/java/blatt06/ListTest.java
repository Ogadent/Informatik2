package blatt06;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class ListTest extends Frame implements ActionListener {

	private static final long serialVersionUID = -4301732115667209631L;

	private TextField input;
	private List show;
	private java.util.List<Integer> data;
	private SearchDialog searchDialog;

	public ListTest() {
		super("Aufgabe24");
		data = new ArrayList<>();
		input = new TextField(10);
		this.add(input, BorderLayout.NORTH);

		Button send = new Button("Senden");
		this.add(send, BorderLayout.EAST);
		send.addActionListener(this);

		show = new List(5);
		this.add(show, BorderLayout.SOUTH);
		
		Button searchButton = new Button("Suchen");
		add(searchButton, BorderLayout.WEST);
		searchButton.addActionListener(e -> {
			searchDialog.setLocation(getX() + searchDialog.getWidth() + 10, getY());
			searchDialog.setVisible(true);
		});

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		pack();
		searchDialog = new SearchDialog(this);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void search(String s) {
		Integer parsedInt = null;
		try {
			parsedInt = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			new Warndialog(this, e.getMessage());
			return;
		}
		int index = data.indexOf(parsedInt);
		if (index != -1) {
			show.select(index);
		} else {
			for (int i : show.getSelectedIndexes()) {
				show.deselect(i);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Senden")) {
			String s = input.getText();
			try {
				Integer n = Integer.valueOf(s);
				input.setText("");
				data.add(n);
				show.add(n.toString());
			} catch (NumberFormatException nfe) {
				new Warndialog(this, nfe.getMessage());
			}
		}
	}
	
	public static void main(String[] args) {
		new ListTest();
	}
}
