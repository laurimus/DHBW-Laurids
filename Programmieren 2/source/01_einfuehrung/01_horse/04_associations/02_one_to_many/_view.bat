@echo off

set "file01=Breed.java"
set "file02=Gender.java"
set "file03=Colour.java"
set "file04=Chip.java"
set "file05=Feed.java"
set "file06=MovementMode.java"
set "file07=Owner.java"
set "file08=DressageHorse.java"
set "file09=Application.java"

set "file_list="

if exist "%file01%" set "file_list=%file_list% "%file01%""
if exist "%file02%" set "file_list=%file_list% "%file02%""
if exist "%file03%" set "file_list=%file_list% "%file03%""
if exist "%file04%" set "file_list=%file_list% "%file04%""
if exist "%file05%" set "file_list=%file_list% "%file05%""
if exist "%file06%" set "file_list=%file_list% "%file06%""
if exist "%file07%" set "file_list=%file_list% "%file07%""
if exist "%file08%" set "file_list=%file_list% "%file08%""
if exist "%file09%" set "file_list=%file_list% "%file09%""

if not "%file_list%"=="" (
    "%notepadpp_path%" -multiInst -nosession -ro %file_list%
)