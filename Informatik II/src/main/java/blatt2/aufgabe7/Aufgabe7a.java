package blatt2.aufgabe7;

public class Aufgabe7a {

	public static void main(String[] args) {
		try {
			final Article article = new Article("Bleistift", 0, 0.75);
			article.setDiscount(10);
			article.print();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

}
