package blatt2.aufgabe6;

import java.util.ArrayList;
import java.util.List;

public class Aufgabe6b {

	public static void main(String[] args) {
		final List<String> list = new ArrayList<>();
		for (String s : args) {
			list.add(s);
		}
		list.remove("delete");
		System.out.println("Die Liste ist " + (list.isEmpty() ? "" : "nicht ") + "leer");
	}
}
