package exceptions;

/**
 * Thrown when the program is unable to connect to an external database.
 */
public class DatabaseNotRespondingException extends Exception {
	
	/**
	 * Creates an instance of the <code>DatabaseNotRespondingException</code> class.
	 */
	public DatabaseNotRespondingException() {
		super("Failed to establish connection to external inventory system database.");
	}
}
