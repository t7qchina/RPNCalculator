package operators.validators;

import exceptions.OutOfHistoryBoundaryException;
import helpers.*;
import operators.Executable;

public class HistoryBoundaryChecker implements Executable {

    private static final String UNDO = "undo";
    private static final String REDO = "redo";
    private HistoryHandler handler;

    public HistoryBoundaryChecker(HistoryHandler h) {
        this.handler = h;
    }

    @Override
    public void execute(Command command, OperandStack stack) {
        if (command.getCommand()
                .toLowerCase()
                .equals(REDO) && handler.getHistorySize() == handler.getCurrentIndex() + 1) {
            throw new OutOfHistoryBoundaryException(command, OutOfHistoryBoundaryException.Position.Tail);
        } else if (command.getCommand()
                .toLowerCase()
                .equals(UNDO) && handler.getCurrentIndex() == 0) {
            throw new OutOfHistoryBoundaryException(command, OutOfHistoryBoundaryException.Position.Head);
        }
    }
}
