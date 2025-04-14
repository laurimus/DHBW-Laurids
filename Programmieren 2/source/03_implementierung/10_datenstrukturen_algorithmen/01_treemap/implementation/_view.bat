@echo off

set "file01=Airplane.java"
set "file02=Application.java"

set "file_list="

if exist "%file01%" set "file_list=%file_list% "%file01%""
if exist "%file02%" set "file_list=%file_list% "%file02%""

if not "%file_list%"=="" (
    "%notepadpp_path%" -multiInst -nosession -ro %file_list%
)