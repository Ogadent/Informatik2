package blatt03.aufgabe09;

public class Aufgabe9a {

	public static void main(String[] args) {
		if (args.length % 3 != 0) {
			return;
		}
		int circleCount = 0;
		for (int i = 0; i < args.length; i++) {
			try {
				final int x = Integer.parseInt(args[i++]);
				final int y = Integer.parseInt(args[i++]);
				final int r = Integer.parseInt(args[i]);
				new Circle(r, new Point(x, y));
				circleCount++;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println(circleCount);
	}
}
