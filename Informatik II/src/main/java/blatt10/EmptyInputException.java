package blatt10;

import java.awt.TextField;

public class EmptyInputException extends Exception {

	/**
	 * use serialVersionUID from JDK 1.0.2 for interoperability
	 */
	private static final long serialVersionUID = -686096293062473043L;
	
	private final TextField source;

	public EmptyInputException(final TextField source) {
		super("Leere Eingabe");
		this.source = source;
	}
	
	public TextField getSource() {
		return source;
	}
}
