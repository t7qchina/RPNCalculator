package exceptions;

import helpers.Command;

public class ExitException extends CalculatorException {
    public ExitException(Command command) {
        super(command, "Exit command received, exit..");
    }
}
