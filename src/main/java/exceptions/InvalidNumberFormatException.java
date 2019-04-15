package exceptions;

import helpers.Command;

public class InvalidNumberFormatException extends CalculatorException {
    public InvalidNumberFormatException(Command command) {
        super(command, String.format("Invalid number format: %s", command));
    }
}
