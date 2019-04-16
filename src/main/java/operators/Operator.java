package operators;

import helpers.Command;
import helpers.OperandStack;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Operator implements Executable {

    List<Executable> validators;

    private Integer priority;

    private Pattern regex;

    public Operator(String pattern, int priority) {
        this.validators = new LinkedList<>();
        this.regex = Pattern.compile(pattern);
        this.priority = priority;
    }

    public boolean matches(Command comm) {
        Matcher matcher = regex.matcher(comm.getCommand()
                .toLowerCase());
        return matcher.matches();
    }

    public Integer getPriority() {
        return this.priority;
    }

    @Override
    public final void execute(Command command, OperandStack stack) {
        for (int i = 0; i < validators.size(); i++) {
            validators.get(i)
                    .execute(command, stack);
        }
        this.internalExecute(command, stack);
    }

    protected abstract void internalExecute(Command command, OperandStack stack);
}
