package exceptions;

import helpers.Command;

public class SignException extends CalculatorException {

    public SignException(Command command, Sign sign) {
        super(command, String.format("Operand cannot be %s number", sign.toString()));
    }

    public enum Sign {
        Positive,
        Negative
    }
}
