package exceptions;

import helpers.Command;

import java.math.BigDecimal;

public class ValueRangeException extends CalculatorException {

    public ValueRangeException(Command command, BigDecimal value, BigDecimal min, BigDecimal max) {
        super(command, String.format("Value %s is not in range between %s and %s", value, min, max));
    }
}
