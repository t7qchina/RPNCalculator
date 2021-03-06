import exceptions.CalculatorException;
import exceptions.ExitException;
import helpers.*;
import operators.Number;
import operators.*;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private OperandStack stack = new OperandStack();
    private List<Operator> operators = new ArrayList<>();
    private InputHandler inputHandler = new PlainTextHandler();
    private ParameterReceiver receiver = new ConsoleReceiver();

    public Calculator() {
        operators.add(new CommandPrechecker());
        operators.add(new Exit());
        operators.add(new Number());
        operators.add(new Add());
        operators.add(new Subtract());
        operators.add(new Multiply());
        operators.add(new Divide());
        operators.add(new Clear());
        operators.add(new Undo());
        operators.add(new Redo());
        operators.add(new Sqrt());
        operators.add(new Factorial());
        operators.add(new Pi());
        operators.add(new Perimeter());
        operators.add(new Pow());
        operators.add(new StackSnapshot());
        operators.sort(new OperatorComparator());
    }

    public static void main(String[] args) {
        new Calculator().start();
    }

    private void start() {
        while (true) {
            String parameters = receiver.receive();
            List<Command> commands = inputHandler.getCommands(parameters);
            try {
                for (Command comm : commands) {
                    for (Operator operator : operators) {
                        if (operator.matches(comm)) {
                            operator.execute(comm, stack);
                        }
                    }
                }
            } catch (ExitException ex) {
                System.out.println(ex.getMessage());
                return;
            } catch (CalculatorException ex) {
                System.out.println(ex.getMessage());
            } finally {
                System.out.println(String.format("Stack: %s" + System.lineSeparator(), stack.toString()));
            }
        }
    }
}
