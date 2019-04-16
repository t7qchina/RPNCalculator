package operators;

import exceptions.InvalidCommandException;
import helpers.Command;
import helpers.OperandStack;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandPrechecker extends Operator {

    static final String PATTERN = "^\\S+$";

    private Pattern p;

    public CommandPrechecker() {
        super(PATTERN, 0);
        p = Pattern.compile(getSupportedPatterns());
    }

    @Override
    protected void internalExecute(Command command, OperandStack stack) {
        Matcher m = p.matcher(command.getCommand()
                .toLowerCase());
        if (!m.matches()) {
            throw new InvalidCommandException(command);
        }
    }

    private String getSupportedPatterns() {
        List<String> patterns = new ArrayList<>();
        patterns.add(Exit.PATTERN);
        patterns.add(Add.PATTERN);
        patterns.add(Clear.PATTERN);
        patterns.add(Divide.PATTERN);
        patterns.add(Multiply.PATTERN);
        patterns.add(Number.PATTERN);
        patterns.add(Sqrt.PATTERN);
        patterns.add(Subtract.PATTERN);
        patterns.add(Undo.PATTERN);
        patterns.add(Redo.PATTERN);
        patterns.add(Factorial.PATTERN);
        patterns.add(Pi.PATTERN);
        patterns.add(Pow.PATTERN);
        patterns.add(Perimeter.PATTERN);
        return String.join("|", patterns);
    }
}
