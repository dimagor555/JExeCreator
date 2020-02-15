package ru.dimagor555.jexecreator;

public class CommandsHandler {

    void handleCommand(String input) {
        if (isCommand(input)) {
            executeCommand(input);
        } else {
            Main.console.printCommandDoNotExist(getCommandStrFromInput(input));
        }
    }

    private void executeCommand(String input) {
        Commands command = getCommand(getCommandStrFromInput(input).toUpperCase());
        switch(command) {
            case HELP:
                Main.console.printHelp();
                break;
            case CREATE:
                createExe(input);
                break;
        }
    }

    private void createExe(String input) {
        String out = null;
        String cmd = null;
        String[] cmdWithArgs = input.split(" ");
        for (int i = 1; i < cmdWithArgs.length; i++) {
            try {
                String[] argument = cmdWithArgs[i].split("=");
                switch (argument[0]) {
                    case "out":
                        out = argument[1].replaceAll("\"", "");
                        break;
                    case "cmd":
                        cmd = argument[1].replaceAll("\"", "");
                        break;
                }
            } catch (ArrayIndexOutOfBoundsException ex) {
            }
        }
        if (out != null && cmd != null) {
            Main.exeCreator.createExe(out, cmd);
        } else {
            Main.console.printUseAllArgs();
        }
    }

    private boolean isCommand(String input) {
        try {
            String command = getCommandStrFromInput(input).toUpperCase();
            getCommand(command);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    private Commands getCommand(String command) throws IllegalArgumentException {
        return Commands.valueOf(command);
    }

    private String getCommandStrFromInput(String input) {
        return input.split(" ")[0];
    }

    enum Commands {
        HELP, CREATE
    }
}
