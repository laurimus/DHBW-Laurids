@echo off

set "file01=Application.java"

set "file_list="

if exist "%file01%" set "file_list=%file_list% "%file01%""

if not "%file_list%"=="" (
    "%notepadpp_path%" -multiInst -nosession -ro %file_list%
)