REM http://www.codeproject.com/Tips/119828/Running-a-bat-file-as-administrator-Correcting-cur
@setlocal enableextensions
@cd /d "%~dp0"
set OLDDIR=%CD%
echo "Command History of the date" >> "CommandHistory.txt"
date /t  >> "CommandHistory.txt"
DOSKEY /history >> "CommandHistory.txt"