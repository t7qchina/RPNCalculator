package helpers;

import java.io.Console;

public class ConsoleReceiver implements ParameterReceiver {

    Console con;

    public ConsoleReceiver() {

        this.con = System.console();
    }

    @Override
    public String receive() {
        con.printf("Please input paramters: ");
        return con.readLine();
    }
}
