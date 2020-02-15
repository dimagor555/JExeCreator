#include <windows.h>
 
int WINAPI WinMain(HINSTANCE hInst, HINSTANCE hPrev, LPSTR szCmdLine, int nShowCmd) {
	
    char cLine[] = "commandHere";
 
    STARTUPINFO cif;
    ZeroMemory(&cif, sizeof(STARTUPINFO));
    PROCESS_INFORMATION pi;
    CreateProcessA(NULL, cLine, NULL, NULL, FALSE, CREATE_NO_WINDOW, NULL, NULL, &cif, &pi);

    WaitForSingleObject(pi.hProcess, INFINITE);

    CloseHandle(pi.hProcess);
    CloseHandle(pi.hThread);

    return 0;
}
