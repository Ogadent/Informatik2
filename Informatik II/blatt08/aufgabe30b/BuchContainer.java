package blatt08;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MitarbeiterContainer implements Iterable<Mitarbeiter> {

	private final List<Mitarbeiter> alleMitarbeiter = new ArrayList<>();

	@Override
	public Iterator<Mitarbeiter> iterator() {
		return alleMitarbeiter.iterator();
	}
}
