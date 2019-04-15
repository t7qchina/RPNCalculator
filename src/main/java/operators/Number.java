package operators;

import helpers.Command;
import helpers.OperandStack;
import operators.validators.NumberValidator;

import java.math.BigDecimal;

public class Number extends Operator {

    static final String pattern = "^[+-]?\\d+(\\.\\d+)?([Ee][+-]?\\d+)?$";

    public Number() {
        super(pattern);
        this.priority = 100;
        this.Validators.add(new NumberValidator());
    }

    @Override
    protected void internalExecute(Command command, OperandStack stack) {
        stack.push(new BigDecimal(command.getCommand()));
    }
}
