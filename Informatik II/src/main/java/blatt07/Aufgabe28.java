package blatt07;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

public class Aufgabe28 extends Frame {

	public Aufgabe28() {
		setSize(100, 100);
		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("Aufgabe28");
		menuBar.add(menu);
		MenuItem item = new MenuItem("close");
		item.addActionListener(e -> dispose());
		menu.add(item);
		setMenuBar(menuBar);
		setVisible(true);
	}
}
