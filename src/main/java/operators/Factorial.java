package operators;

import helpers.Command;
import helpers.OperandStack;
import operators.validators.*;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Factorial extends Operator {

    static final String PATTERN = "^\\!$";

    public Factorial() {
        super(PATTERN, 100);
        this.validators.add(new ParametersCountValidator(1));
        this.validators.add(new PositiveValidator());
        this.validators.add(new IntegerValidator());
    }

    @Override
    protected void internalExecute(Command command, OperandStack stack) {
        BigInteger n = stack.popLastOperand()
                .toBigIntegerExact();

        BigInteger start = BigInteger.ONE;
        BigInteger result = BigInteger.ONE;
        while (start.compareTo(n) <= 0) {
            result = result.multiply(start);
            start = start.add(BigInteger.ONE);
        }
        stack.push(new BigDecimal(result));

    }
}
