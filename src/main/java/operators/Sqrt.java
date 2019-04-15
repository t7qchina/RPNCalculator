/**
 * IMPORTANT: 本文件中包含从互联网上收录的平方根算法，并非本人所做
 * http://blog.udby.com/archives/17
 */

package operators;

import helpers.Command;
import helpers.OperandStack;
import operators.validators.ParametersCountValidator;
import operators.validators.PositiveValidator;

import java.math.*;

public class Sqrt extends Operator {

    static final String PATTERN = "^sqrt$";
    private static final BigDecimal TWO = BigDecimal.valueOf(2L);

    public Sqrt() {
        super(PATTERN, 100);
        this.validators.add(new ParametersCountValidator(1));
        this.validators.add(new PositiveValidator());
    }

    private BigDecimal sqrt(BigDecimal x, MathContext mc) {
        if (x.equals(BigDecimal.ZERO)) {
            return BigDecimal.ZERO;
        }

        BigDecimal g = x.divide(TWO, mc);
        boolean done = false;
        final int maxIterations = mc.getPrecision() + 1;
        for (int i = 0; !done && i < maxIterations; i++) {
            // r = (x/g + g) / 2
            BigDecimal r = x.divide(g, mc);
            r = r.add(g);
            r = r.divide(TWO, mc);
            done = r.equals(g);
            g = r;
        }
        return g;
    }

    @Override
    protected void internalExecute(Command command, OperandStack stack) {
        BigDecimal operand = stack.popLastNOperands(1)
                .get(0);
        stack.push(sqrt(operand, new MathContext(OperandStack.PRECISION, RoundingMode.HALF_UP)));
    }
}
