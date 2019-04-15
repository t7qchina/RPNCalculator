package operators;

import helpers.HistoryHandler;

public abstract class HistoryOperator extends Operator {

    static final HistoryHandler HANDLER = new HistoryHandler();

    public HistoryOperator(String pattern, int priority) {
        super(pattern, priority);
    }
}
