package operators;

import helpers.Command;
import helpers.OperandStack;
import operators.validators.NumberValidator;

import java.math.BigDecimal;

public class Number extends Operator {

    static final String PATTERN = "^[+-]?\\d+(\\.\\d+)?([Ee][+-]?\\d+)?$";

    public Number() {
        super(PATTERN, 100);
        this.validators.add(new NumberValidator());
    }

    @Override
    protected void internalExecute(Command command, OperandStack stack) {
        stack.push(new BigDecimal(command.getCommand()));
    }
}
