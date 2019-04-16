package helpers;

import java.math.*;
import java.text.NumberFormat;
import java.util.Stack;
import java.util.stream.Collectors;

public class OperandStack extends Stack<BigDecimal> {

    public static final MathContext PRECISION = new MathContext(15, RoundingMode.HALF_UP);
    NumberFormat formatter;

    public OperandStack() {
        formatter = NumberFormat.getInstance();
        formatter.setMaximumFractionDigits(10);
    }

    public OperandStack getLastNOperands(int n) {
        OperandStack result = new OperandStack();
        for (int i = this.size() - n; i < this.size(); i++) {
            result.push(this.get(i));
        }
        return result;
    }

    public BigDecimal getLastOperand() {
        return getLastNOperands(1).get(0);
    }

    public OperandStack popLastNOperands(int n) {
        OperandStack result = getLastNOperands(n);
        for (int i = 0; i < n; i++) {
            this.pop();
        }
        return result;
    }

    public BigDecimal popLastOperand() {
        return popLastNOperands(1).get(0);
    }

    @Override
    public BigDecimal push(BigDecimal item) {
        return super.push(item.setScale(PRECISION.getPrecision(), PRECISION.getRoundingMode())
                .stripTrailingZeros());
    }

    @Override
    public String toString() {
        return this.stream()
                .map(n -> formatter.format(n))
                .collect(Collectors.joining(" "));
    }
}
