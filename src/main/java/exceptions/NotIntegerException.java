package exceptions;

import helpers.Command;

import java.math.BigDecimal;

public class NotIntegerException extends CalculatorException {
    public NotIntegerException(Command command, BigDecimal n) {
        super(command, String.format("Number %s is not a Integer", n.toPlainString()));
    }
}
