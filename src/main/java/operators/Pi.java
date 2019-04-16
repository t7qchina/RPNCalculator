package operators;

import helpers.Command;
import helpers.OperandStack;

import java.math.BigDecimal;

public class Pi extends Operator {

    static final String PATTERN = "^pi$";

    public Pi() {
        super(PATTERN, 100);
    }

    @Override
    protected void internalExecute(Command command, OperandStack stack) {
        stack.push(new BigDecimal("3.1415926535897932384626433832795028841971"));
    }
}
