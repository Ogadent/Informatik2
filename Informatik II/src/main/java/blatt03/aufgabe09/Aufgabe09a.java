package blatt03.aufgabe09;

public class Aufgabe9a {

	public static void main(String[] args) {
		if (args.length % 3 != 0) {
			return;
		}
		for (int i = 0; i < args.length; i++) {
			try {
				final int x = Integer.parseInt(args[i++]);
				final int y = Integer.parseInt(args[i++]);
				final int r = Integer.parseInt(args[i]);
				final Point p = new Point(x, y);
				new Circle(r, p);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println(Circle.getCount());
	}
}
