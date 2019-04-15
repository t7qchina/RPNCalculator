package exceptions;

import helpers.Command;

public class InsufficientParametersException extends CalculatorException {

    public InsufficientParametersException(Command command) {
        super(command, "Insufficient parameters");
    }
}
