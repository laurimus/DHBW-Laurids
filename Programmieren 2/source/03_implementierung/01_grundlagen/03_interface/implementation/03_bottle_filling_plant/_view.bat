@echo off

set "file01=shared/LiquidType.java"
set "file02=shared/Bottle.java"
set "file03=machine/IMachine.java"
set "file04=machine/Unscrambler.java"
set "file05=machine/Rinser.java"
set "file06=machine/Filler.java"
set "file07=machine/Capper.java"
set "file08=machine/Labeler.java"
set "file09=machine/Packager.java"
set "file10=machine/Palletizer.java"
set "file11=machine/ProductionLine.java"
set "file12=main/BottleFillingPlant.java"

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
if exist "%file12%" set "file_list=%file_list% "%file12%""

if not "%file_list%"=="" (
    "%notepadpp_path%" -multiInst -nosession -ro %file_list%
)