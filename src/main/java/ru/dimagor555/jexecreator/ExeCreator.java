package ru.dimagor555.jexecreator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ExeCreator {

    public static final String CPP_FILE_NAME = "exeStarter.cpp";
    private boolean errors = false;

    public void createExe(String fileName, String command) {
        createCppFileToCompile(command);
        execCompileCommand(fileName);
        deleteCppFile();
        if (!errors) {
            Main.console.printOperationCompletedSuccessfully();
        }
    }

    private void createCppFileToCompile(String command) {
        String cppFileStr = TemplateLoader.loadTemplate();
        cppFileStr = cppFileStr.replace("commandHere", command);
        try {
            File cppFile = new File(CPP_FILE_NAME);
            cppFile.createNewFile();
            Files.write(Paths.get(CPP_FILE_NAME), cppFileStr.getBytes(), StandardOpenOption.WRITE);
        } catch (IOException e) {
            System.out.println("An error occurred while writing file");
            errors = true;
            e.printStackTrace();
        }
    }

    private void execCompileCommand(String fileName) {
        String command = String.format("x86_64-w64-mingw32-gcc -o %s.exe %s -mwindows",
                fileName, CPP_FILE_NAME);
        try {
            Process proc = Runtime.getRuntime().exec(command, null);
            proc.waitFor();
            proc.destroy();
        }
        catch (IOException e) {
            System.out.println("An error occurred while compiling .exe file");
            errors = true;
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            System.out.println("Thread sleep interrupted");
            errors = true;
            e.printStackTrace();
        }
    }

    private void deleteCppFile() {
        File cppFile = new File(CPP_FILE_NAME);
        cppFile.delete();
    }
}
