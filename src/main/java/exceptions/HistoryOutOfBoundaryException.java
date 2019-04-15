package exceptions;

import helpers.Command;

public class HistoryOutOfBoundaryException extends CalculatorException {

    public HistoryOutOfBoundaryException(Command command, Position position) {
        super(command, String.format("Already at %s position, cannot %s", position, position == Position.Head ? "undo" : "redo"));
    }

    public enum Position {
        Head,
        Tail
    }
}
