package blatt2.aufgabe7;

public class Book {
	
	private String title;
	private String isbn10;
	
	public Book(String isbn10) throws IllegalArgumentException {
		setIsbn10(isbn10);
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getIsbn10() {
		return this.isbn10;
	}
		
	private static boolean checkTitle(String title) {
		return true;
	}
	
	public void setTitle(String title) throws IllegalArgumentException {
		if (!checkTitle(title))
			throw new IllegalArgumentException("Titel ungültig");
		this.title = title;
	}

	private static boolean checkIsbn10(String isbn10) {
		if (isbn10.length() != 10)
			return false;
		for (int i = 0; i < 9; ++i) {
			if (!Character.isDigit(isbn10.charAt(i)))
				return false;
		}
		int z = 0;
		for (int j = 0; j < 9; ++j) 
			z = z + (j + 1) * (isbn10.charAt(j) - '0');
		int r = z % 11;
		if ((r < 10) && (isbn10.charAt(9) != '0' + r))
			return false;
		if ((r == 10) && (isbn10.charAt(9) != 'X'))
			return false;
		return true;
	}
	
	public void setIsbn10(String isbn10) throws IllegalArgumentException {
		if (!checkIsbn10(isbn10))
			throw new IllegalArgumentException("ISBN10 ungültig");
		this.isbn10 = isbn10;
	}
}
