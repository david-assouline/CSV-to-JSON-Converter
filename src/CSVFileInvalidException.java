public class CSVFileInvalidException extends Exception {


    /**
     * Default constructor for CSVFileInvalidException
     */
    public CSVFileInvalidException() {
        super("Invalid CSV File Exception");
    }

    /**
     * Parameterized constructor if program wants to pass a custom message
     * @param message a message string to display to the user
     */
    public CSVFileInvalidException(String message) {
        super(message);
    }
}
