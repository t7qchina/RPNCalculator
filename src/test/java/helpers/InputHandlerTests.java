package helpers;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class InputHandlerTests {
    @Test
    public void testCorrectInput() {
        List<Command> commands = InputHandler.getCommands("1.23 4.56 *");

        Assert.assertEquals(3, commands.size());

        Command command = commands.get(0);
        Assert.assertEquals(1, command.getPosition());
        Assert.assertEquals("1.23", command.getCommand());

        command = commands.get(1);
        Assert.assertEquals(6, command.getPosition());
        Assert.assertEquals("4.56", command.getCommand());

        command = commands.get(2);
        Assert.assertEquals(11, command.getPosition());
        Assert.assertEquals("*", command.getCommand());
    }

    @Test
    public void testEmptyInput() {
        List<Command> commands = InputHandler.getCommands("");
        Assert.assertEquals(0, commands.size());

        commands = InputHandler.getCommands(" ");
        Assert.assertEquals(0, commands.size());
    }

    @Test
    public void testReduntantSpace() {
        List<Command> commands = InputHandler.getCommands("   1.23 4.56   *   ");

        Assert.assertEquals(3, commands.size());

        Command command = commands.get(0);
        Assert.assertEquals(4, command.getPosition());
        Assert.assertEquals("1.23", command.getCommand());

        command = commands.get(1);
        Assert.assertEquals(9, command.getPosition());
        Assert.assertEquals("4.56", command.getCommand());

        command = commands.get(2);
        Assert.assertEquals(16, command.getPosition());
        Assert.assertEquals("*", command.getCommand());
    }


    @Test
    public void testNoTrailingSpace() {
        List<Command> commands = InputHandler.getCommands("   1.23 4.56   *");

        Assert.assertEquals(3, commands.size());

        Command command = commands.get(0);
        Assert.assertEquals(4, command.getPosition());
        Assert.assertEquals("1.23", command.getCommand());

        command = commands.get(1);
        Assert.assertEquals(9, command.getPosition());
        Assert.assertEquals("4.56", command.getCommand());

        command = commands.get(2);
        Assert.assertEquals(16, command.getPosition());
        Assert.assertEquals("*", command.getCommand());
    }
}
