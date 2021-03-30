public class InvalidException extends Exception {


    /**
     * Default constructor for Invalid Exception
     */
    public InvalidException() {
        super("Error: Input row cannot be parsed due to missing information");
    }

    /**
     * Parameterized constructor if program wants to pass a custom message
     * @param message a message string to display to the user
     */
    public InvalidException(String message) {
        super(message);
    }
}
