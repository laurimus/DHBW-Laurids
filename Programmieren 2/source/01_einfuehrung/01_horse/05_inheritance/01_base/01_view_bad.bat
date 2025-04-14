@echo off

set "file01=01_bad/shared/Breed.java"
set "file02=01_bad/shared/Gender.java"
set "file03=01_bad/shared/Colour.java"
set "file04=01_bad/shared/Chip.java"
set "file05=01_bad/shared/Feed.java"
set "file06=01_bad/shared/MovementMode.java"
set "file07=01_bad/shared/Owner.java"
set "file08=01_bad/shared/Heart.java"
set "file09=01_bad/main/DressageHorse.java"
set "file10=01_bad/main/Jumper.java
set "file11=01_bad/main/Application.java"

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
if exist "%file10%" set "file_list=%file_list% "%file10%""
if exist "%file11%" set "file_list=%file_list% "%file11%""

if not "%file_list%"=="" (
    "%notepadpp_path%" -multiInst -nosession -ro %file_list%
)