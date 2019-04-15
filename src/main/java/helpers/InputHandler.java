package helpers;

import java.util.LinkedList;
import java.util.List;

public class InputHandler {
    public static List<Command> getCommands(String input) {
        LinkedList<Command> commands = new LinkedList<>();
        int start = 0;
        int end = 0;
        while (end < input.length()) {
            if (input.charAt(start) == ' ') {
                start++;
                end++;
            } else {
                if (end == input.length() - 1 || input.charAt(end) == ' ') {
                    if (end == input.length() - 1) {
                        commands.addLast(new Command(start + 1, input.substring(start, end + 1)));
                    } else {
                        commands.addLast(new Command(start + 1, input.substring(start, end)));
                    }
                    end++;
                    start = end;
                } else {
                    end++;
                }
            }
        }
        return commands;
    }

}
