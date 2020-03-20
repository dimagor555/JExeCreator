## JExeCreator  
JExeCreator is a console program for creating .exe files to run Java modular apps. 
But you can put any command in it.

## Installing
### Installing additional repositories
Run `sudo apt install mingw-w64` to install Windows C++ compiler. JExeCreator uses `x86_64-w64-mingw32-gcc` to compile .exe file
### Installing JExeCreator
1. Donwload
2. Extract the archive
3. Run `./JExeCreator-Linux/bin/JExeCreator` or `sh JExeCreator-Linux/bin/JExeCreator` to start the program

## How to use
To create .exe starter use comman `JExeCreator create` with arguments `out` and `cmd`  
`out` is an output file name without .exe file extension  
`cmd` is a command to run by .exe starter  
Full commad is `JExeCreator create out="app" cmd="java.exe -m MyModule/org.Main"`

Default command to run Java modular app is `"path/to/java.exe -m ModuleName ModuleName/org.company.Main"`. 
You can also get additional help by running program with the `help` command.
