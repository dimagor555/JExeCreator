package ru.dimagor555.jexecreator;

public class Main {

    static ConsoleManager console = new ConsoleManager();
    static CommandsHandler commandsHandler = new CommandsHandler();
    static ExeCreator exeCreator = new ExeCreator();

    public static void main(String[] args) {
        String command = String.join(" ", args);
        commandsHandler.handleCommand(command);
    }
}
