package blatt04.aufgabe15b;

import java.util.ArrayList;
import java.util.List;

public class Student {

	private List<Studiengang> studiengang;
	
	public Student(Studiengang s) {
		studiengang = new ArrayList<>();
		studiengang.add(s);
	}
	
	public void linkStudiengang(Studiengang s) {
		if (!s.isWiederholungsfrei()) {
			throw new IllegalArgumentException("s ist nicht wiederholungsfrei");
		}
		studiengang.add(s);
	}
}
