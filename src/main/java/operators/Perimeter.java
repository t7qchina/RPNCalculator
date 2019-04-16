package operators;

import helpers.Command;
import helpers.OperandStack;
import operators.validators.ParametersCountValidator;

public class Perimeter extends Operator {
    static final String PATTERN = "^perimeter$";

    Operator pi;
    Operator two;
    Operator multiply;

    public Perimeter() {
        super(PATTERN, 100);
        this.two = new Number();
        this.pi = new Pi();
        this.multiply = new Multiply();
        this.validators.add(new ParametersCountValidator(1));
    }

    @Override
    protected void internalExecute(Command command, OperandStack stack) {
        two.execute(new Command(command.getPosition(), "2"), stack);
        pi.execute(command, stack);
        multiply.execute(command, stack);
        multiply.execute(command, stack);
    }
}
