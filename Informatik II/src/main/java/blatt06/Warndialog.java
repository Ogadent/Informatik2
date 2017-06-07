package blatt06;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Warndialog extends Dialog implements ActionListener {

	private static final long serialVersionUID = -3548884818929082036L;

	public Warndialog(Frame f, String warning) {
		super(f, "Warnung", true);

		Label w = new Label(warning);
		add(w, BorderLayout.NORTH);
		
		Button close = new Button("Ok");
		add(close, BorderLayout.SOUTH);
		close.addActionListener(this);

		setLocation(f.getLocation().x + 50, f.getLocation().y + 50);
		pack();
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getActionCommand().equals("Ok"))
		dispose();
	}
}
