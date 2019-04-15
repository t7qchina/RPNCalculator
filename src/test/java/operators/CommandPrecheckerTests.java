package operators;

import exceptions.InvalidCommandException;
import helpers.Command;
import helpers.OperandStack;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Enclosed.class)
public class CommandPrecheckerTests {

    @RunWith(Parameterized.class)
    public static class InvalidTests {

        @Parameterized.Parameter
        public String input;
        CommandPrechecker validator;

        @Parameterized.Parameters
        public static Collection<String> data() {
            return Arrays.asList("abc", "1e", "e1", "/1", "/*");
        }

        @Before
        public void setup() {
            validator = new CommandPrechecker();
        }

        @Test(expected = InvalidCommandException.class)
        public void testInvalidCommands() {
            OperandStack stack = new OperandStack();
            validator.execute(new Command(0, input), stack);
        }
    }

    public static class ValidTests {

        CommandPrechecker validator;

        @Before
        public void setup() {
            validator = new CommandPrechecker();
        }

        @Test
        public void testValidCommands() {
            OperandStack stack = new OperandStack();
            validator.execute(new Command(0, "1.2"), stack);
            validator.execute(new Command(0, "1.2e3"), stack);
            validator.execute(new Command(0, "1.2"), stack);
            validator.execute(new Command(0, "-1.2e-2"), stack);
            validator.execute(new Command(0, "redo"), stack);
            validator.execute(new Command(0, "undo"), stack);
            validator.execute(new Command(0, "+"), stack);
            validator.execute(new Command(0, "-"), stack);
            validator.execute(new Command(0, "*"), stack);
            validator.execute(new Command(0, "/"), stack);
            validator.execute(new Command(0, "sqrt"), stack);
        }
    }


}
