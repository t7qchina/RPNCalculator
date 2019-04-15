package exceptions;

import helpers.Command;

public class CalculatorException extends RuntimeException {

    public CalculatorException(Command command, String message) {
        super(String.format("Operator \"%s\" (position %s): %s", command.getCommand(), command.getPosition(), message));
    }
}
