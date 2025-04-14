@echo off

set "file01=07/utility/Utility.java"
set "file02=07/jukebox/JukeboxStatus.java"
set "file03=07/jukebox/MoneyCollector.java"
set "file04=07/shared/Artist.java"
set "file05=07/shared/Song.java"
set "file06=07/jukebox/SongQueue.java"
set "file07=07/jukebox/Jukebox.java"
set "file08=07/main/Application.java"

set "file_list="

if exist "%file01%" set "file_list=%file_list% "%file01%""
if exist "%file02%" set "file_list=%file_list% "%file02%""
if exist "%file03%" set "file_list=%file_list% "%file03%""
if exist "%file04%" set "file_list=%file_list% "%file04%""
if exist "%file05%" set "file_list=%file_list% "%file05%""
if exist "%file06%" set "file_list=%file_list% "%file06%""
if exist "%file07%" set "file_list=%file_list% "%file07%""
if exist "%file08%" set "file_list=%file_list% "%file08%""

if not "%file_list%"=="" (
    "%notepadpp_path%" -multiInst -nosession -ro %file_list%
)