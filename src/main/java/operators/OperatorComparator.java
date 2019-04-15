package operators;

import java.util.Comparator;

public class OperatorComparator implements Comparator<Operator> {
    public int compare(Operator a, Operator b) {
        return a.getPriority() - b.getPriority();
    }
}
