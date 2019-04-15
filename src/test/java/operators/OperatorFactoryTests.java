package operators;

import exceptions.InvalidCommandException;
import helpers.Command;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

public class OperatorFactoryTests {

    private boolean verifyOperatorExists(Command command, Class<?> c) {
        Collection<Operator> operators = OperatorFactory.getOperators(command);
        for (Operator oper : operators) {
            if (oper.getClass() == c) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void testValidCommands() {
        Assert.assertTrue(verifyOperatorExists(new Command(0, "+"), Add.class));
        Assert.assertTrue(verifyOperatorExists(new Command(0, "clear"), Clear.class));
        Assert.assertTrue(verifyOperatorExists(new Command(0, "/"), Divide.class));
        Assert.assertTrue(verifyOperatorExists(new Command(0, "*"), Multiply.class));
        Assert.assertTrue(verifyOperatorExists(new Command(0, "125.23"), Number.class));
        Assert.assertTrue(verifyOperatorExists(new Command(0, "125.23e23"), Number.class));
        Assert.assertTrue(verifyOperatorExists(new Command(0, "redo"), Redo.class));
        Assert.assertTrue(verifyOperatorExists(new Command(0, "sqrt"), Sqrt.class));
        Assert.assertTrue(verifyOperatorExists(new Command(0, "-"), Subtract.class));
        Assert.assertTrue(verifyOperatorExists(new Command(0, "undo"), Undo.class));
    }

    @Test(expected = InvalidCommandException.class)
    public void testInvalidCommand() {
        OperatorFactory.getOperators(new Command(0, "add"));
    }
}
