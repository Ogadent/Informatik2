package blatt06;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SearchDialog extends Dialog {

	private static final long serialVersionUID = 9135763877222804529L;

	public SearchDialog(ListTest list) {
		super(list);
		TextField searchField = new TextField();
		Button searchButton = new Button("Suchen");
		searchButton.addActionListener(e -> list.search(searchField.getText()));
		add(searchField, BorderLayout.CENTER);
		add(searchButton, BorderLayout.SOUTH);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				searchField.setText("");
				setVisible(false);
			}
		});
		pack();
	}
}
