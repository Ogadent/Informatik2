package blatt06;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Aufgabe23 extends Frame {

	private static final long serialVersionUID = 5139610644690802868L;

	TextField userTextField;
	TextField passwordTextField;
	TextArea tableTextArea;

	private Connection connection;

	public Aufgabe23() {
		super("DBZugriff");

		Panel userPanel = new Panel();
		userPanel.add(new Label("User:"));
		userTextField = new TextField(10);
		userPanel.add(userTextField);
		userPanel.add(new Label("Password:"));
		passwordTextField = new TextField(10);
		userPanel.add(passwordTextField);
		Button connect = new Button("Verbinden");
		connect.addActionListener(e -> connect(connect));
		userPanel.add(connect);
		this.add(userPanel, BorderLayout.NORTH);
		this.add(new Label("Table Angestellter:"), BorderLayout.WEST);
		Button load = new Button("Laden");
		load.addActionListener(e -> load(load));
		this.add(load, BorderLayout.EAST);
		tableTextArea = new TextArea(10, 10);
		tableTextArea.setEditable(false);
		this.add(tableTextArea, BorderLayout.SOUTH);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		pack();
		setVisible(true);
	}

	private void connect(Button button) {
		new Thread(() -> {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(
						"jdbc:mysql://educos-srv01.informatik.uni-augsburg.de:3306/theDatabase",
						userTextField.getText(), passwordTextField.getText());
			} catch (SQLException | ClassNotFoundException e) {
				tableTextArea.setText(e.getMessage());
			}
			button.setEnabled(true);
		}).start();
		button.setEnabled(false);
	}

	private void load(Button button) {
		new Thread(() -> {
			try(PreparedStatement prep = connection.prepareStatement("SELECT * FROM Angestellter")) {
				ResultSet result = prep.executeQuery();
				tableTextArea.setText("");
				boolean first = true;
				while (result.next()) {
					if (first) {
						ResultSetMetaData meta = result.getMetaData();
						for (int i = 0; i < meta.getColumnCount(); i++) {
							tableTextArea.append(meta.getColumnLabel(i));
							tableTextArea.append("|");
						}
						tableTextArea.append("\n");
					}
					first = false;
					tableTextArea.append(String.valueOf(result.getInt("ID")));
					tableTextArea.append("|");
					tableTextArea.append(result.getString("Name"));
					tableTextArea.append("|");
					tableTextArea.append(result.getString("Beginn"));
					tableTextArea.append("|");
					tableTextArea.append(result.getString("Ende"));
					tableTextArea.append("|");
					tableTextArea.append(String.valueOf(result.getBoolean("IstZeitangestellter")));
					tableTextArea.append("|");
					tableTextArea.append(String.valueOf(result.getInt("VorgesetzterID")));
					tableTextArea.append("\n");
				}
			} catch (SQLException e) {
				tableTextArea.setText(e.getMessage());
			}
			button.setEnabled(true);
		}).start();
		button.setEnabled(false);
	}

	public static void main(String[] args) {
		new Aufgabe23();
	}
}
