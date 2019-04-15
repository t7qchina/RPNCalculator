package operators;

import helpers.Command;
import helpers.OperandStack;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Operator implements Executable {

    List<Executable> Validators;

    Integer priority;

    Pattern pattern;

    public Operator(String p) {
        this.Validators = new LinkedList<>();
        pattern = Pattern.compile(p);
    }

    public boolean Matches(String comm) {
        String command = comm.toLowerCase();
        Matcher matcher = pattern.matcher(command);
        return matcher.matches();
    }

    public Integer getPriority() {
        return this.priority;
    }

    @Override
    public void execute(Command command, OperandStack stack) {
        for (int i = 0; i < Validators.size(); i++) {
            Validators.get(i)
                    .execute(command, stack);
        }
        this.internalExecute(command, stack);
    }

    protected abstract void internalExecute(Command command, OperandStack stack);
}
