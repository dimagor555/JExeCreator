## JExeCreator  
JExeCreator is a console program for creating .exe files to run Java modular apps. 
Program creates C++ file which runs a command to start Java app. 
And then compiles it using this command: `"x86_64-w64-mingw32-gcc -o *outFileName*.exe *cppFileName* -mwindows"`. 
So you need `x86_64-w64-mingw32-gcc` installed on your PC.  

Default command to run Java modular app is `"path/to/java.exe -m ModuleName ModuleName/org.company.Main"`. 
You can also get additional help by running program with the "help" argument.
