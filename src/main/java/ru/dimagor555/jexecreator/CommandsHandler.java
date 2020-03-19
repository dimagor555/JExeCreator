package ru.dimagor555.jexecreator;

public class CommandsHandler {

    void handleCommand(String[] args) {
        String command = args[0];
        if (isCommand(command)) {
            executeCommand(args);
        } else {
            Main.console.printCommandDoNotExist(command);
        }
    }

    private void executeCommand(String[] args) {
        Commands command = getCommand(args[0]);
        switch(command) {
            case HELP:
                Main.console.printHelp();
                break;
            case CREATE:
                createExe(args);
                break;
        }
    }

    private void createExe(String[] args) {
        String out = null;
        String cmd = null;
        for (int i = 1; i < args.length; i++) {
            try {
                String[] argument = args[i].split("=");
                switch (argument[0]) {
                    case "out":
                        out = argument[1];
                        break;
                    case "cmd":
                        cmd = argument[1];
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

    private boolean isCommand(String command) {
        try {
            getCommand(command);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    private Commands getCommand(String command) throws IllegalArgumentException {
        return Commands.valueOf(command.toUpperCase());
    }

    enum Commands {
        HELP, CREATE
    }
}
