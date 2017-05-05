package blatt2.aufgabe7;

public class Aufgabe7b {

	public static void main(String[] args) {
		try {
			final Book book = new Book("3570552691");
			book.setTitle("Ein kurze Geschichte der Menschheit");
			System.out.println(book.getIsbn10());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}
