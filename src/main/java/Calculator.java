import exceptions.CalculatorException;
import helpers.*;
import operators.Operator;
import operators.OperatorFactory;

import java.util.Collection;
import java.util.List;

public class Calculator {
    OperandStack stack = new OperandStack();

    public static void main(String[] args) {
        new Calculator().start();
    }

    public void start() {
        ParameterReceiver receiver = new ConsoleReceiver();
        while (true) {
            String parameters = receiver.receive();
            process(parameters);
        }
    }

    private synchronized void process(String parameters) {
        List<Command> commands = InputHandler.getCommands(parameters);
        try {
            for (Command comm : commands) {
                Collection<Operator> operators = OperatorFactory.getOperators(comm);
                for (Operator operator : operators) {
                    operator.execute(comm, stack);
                }
            }
        } catch (CalculatorException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(String.format("Stack: %s", stack.toString()));
        System.out.println();
    }
}
