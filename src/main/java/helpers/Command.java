package helpers;

public class Command {
    private int position;
    private String command;

    public Command(int pos, String comm) {
        this.position = pos;
        this.command = comm;
    }

    public int getPosition() {
        return position;
    }

    public String getCommand() {
        return command;
    }
}
