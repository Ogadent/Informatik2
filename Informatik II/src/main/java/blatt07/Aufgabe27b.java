public void delete() {
	String s = show.getSelectedItem();
	Integer n = Integer.valueOf(s);
	data.remove(n);
	update();
	show.removeAll();
	for (Integer i : data) {
		s = i.toString();
		add(s);
	}
	pack();
}