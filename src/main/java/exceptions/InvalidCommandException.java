package exceptions;

import helpers.Command;

public class InvalidCommandException extends CalculatorException {
    public InvalidCommandException(Command command) {
        super(command, "Invalid command");
    }
}
