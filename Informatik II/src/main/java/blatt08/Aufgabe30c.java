public void searchArtikel(final String auswahl) {
	for (Artikel a : container) {
		final String s = artikel.toString();
		final boolean b = auswahl.equals(s);
		if (b) {
			return a;
		}
	}
	return null;
}
