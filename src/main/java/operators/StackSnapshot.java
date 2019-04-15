package operators;

import helpers.Command;
import helpers.OperandStack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StackSnapshot extends HistoryOperator {

    static final String pattern;

    static {
        List<String> patterns = new ArrayList<>();
        patterns.add(Add.pattern);
        patterns.add(Clear.pattern);
        patterns.add(Divide.pattern);
        patterns.add(Multiply.pattern);
        patterns.add(Number.pattern);
        patterns.add(Sqrt.pattern);
        patterns.add(Subtract.pattern);
        pattern = patterns.stream()
                .collect(Collectors.joining("|"));
    }

    public StackSnapshot() {
        super(pattern);
        this.priority = 200;
    }

    @Override
    protected void internalExecute(Command command, OperandStack stack) {
        super.addSnapshot(stack);
    }
}
