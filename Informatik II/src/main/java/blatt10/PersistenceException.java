package blatt10;

public class PersistenceException extends Exception {

	/**
	 * use serialVersionUID from JDK 1.0.2 for interoperability
	 */
	private static final long serialVersionUID = 2616623057485040575L;

	public PersistenceException(String message, Exception cause) {
		super(message, cause);
	}
}
