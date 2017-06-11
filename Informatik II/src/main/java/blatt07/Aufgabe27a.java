public void move(int dx, int dy) {
	try {
		for (GeometricObject o : component) {
			Point p = o.getPosition();
			int x = p.getX();
			int y = p.getY();
			Point q = new Point(x + dx, y + dy);
			o.setPosition(q);
		}
	} catch (IllegalArgumentException e) {
	}
}