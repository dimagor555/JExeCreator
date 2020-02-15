package ru.dimagor555.jexecreator;

public class ConsoleManager {

    private void printGreeting() {
        printOut("It's .exe starter for Java modular apps CREATOR " +
                "Write \"help\" to  list commands\n");
    }

    public void printCommandDoNotExist(String command) {
        printOut(String.format("Command \"%s\" do not exist\nWrite \"help\" to  list commands", command));
    }

    public void printHelp() {
        printGreeting();
        printOut("To create .exe starter use command \"create\" with arguments\n" +
                "\tout=\"Output file name without .exe\"\n" +
                "\tcmd=\"Command to start your app including path to java.exe\"\n\n" +
                "For example:\n\tcreate out=\"Application\" " +
                "cmd=\"Application/bin/java.exe -m ModuleName ModuleName/org.company.Main\"\n");
    }

    public void printUseAllArgs() {
        printOut("You must fill out all arguments: out=\"\" and cmd=\"\"");
    }

    public void printOperationCompletedSuccessfully() {
        printOut("Operation completed successfully");
    }

    private void printOut(String output) {
        System.out.println(output);
    }
}
