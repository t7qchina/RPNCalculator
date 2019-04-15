package exceptions;

import helpers.Command;

public class ZeroDividerException extends CalculatorException {
    public ZeroDividerException(Command command) {
        super(command, "Zero Divider");
    }
}
