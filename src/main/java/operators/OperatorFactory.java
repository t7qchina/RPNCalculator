package operators;

import exceptions.AmbiguousRegexPatternException;
import exceptions.InvalidCommandException;
import helpers.Command;

import java.util.*;

public class OperatorFactory {
    static List<Operator> operators = new LinkedList<>();

    // 此处可用反射实现动态加载，为简便和代码安全原因仍使用普通的初始化方式。
    static {
        operators.add(new Number());
        operators.add(new Add());
        operators.add(new Subtract());
        operators.add(new Multiply());
        operators.add(new Divide());
        operators.add(new Clear());
        operators.add(new Undo());
        operators.add(new Redo());
        operators.add(new Sqrt());
        operators.add(new StackSnapshot());
    }

    public static Collection<Operator> getOperators(Command comm) {
        TreeSet<Operator> results = new TreeSet<>(new OperatorComparator());
        for (Operator operator : operators) {
            if (operator.Matches(comm.getCommand()
                    .toLowerCase()) == true) {
                if (results.contains(operator)) {
                    throw new AmbiguousRegexPatternException(comm, operator.getClass(), results.floor(operator)
                            .getClass());
                }
                results.add(operator);
            }
        }
        if (results.size() == 0) {
            throw new InvalidCommandException(comm);
        }
        return results;
    }
}
