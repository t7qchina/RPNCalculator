package helpers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Stack;
import java.util.stream.Collectors;

public class OperandStack extends Stack<BigDecimal> {

    public static final int PRECISION = 15;
    NumberFormat formatter;

    public OperandStack() {
        formatter = NumberFormat.getInstance();
        formatter.setMaximumFractionDigits(10);
    }

    public OperandStack getLastNOperands(int n) {

        if (this.size() < n) {
            throw new RuntimeException("Insufficient parameters!");
        }

        OperandStack result = new OperandStack();
        for (int i = this.size() - n; i < this.size(); i++) {
            result.push(this.get(i));
        }
        return result;
    }

    public OperandStack popLastNOperands(int n) {
        OperandStack result = getLastNOperands(n);
        for (int i = 0; i < n; i++) {
            this.pop();
        }
        return result;
    }

    @Override
    public BigDecimal push(BigDecimal item) {
        return super.push(item.setScale(PRECISION, RoundingMode.HALF_UP)
                .stripTrailingZeros());
    }

    @Override
    public String toString() {
        return this.stream()
                .map(n -> formatter.format(n))
                .collect(Collectors.joining(" "));
    }
}
