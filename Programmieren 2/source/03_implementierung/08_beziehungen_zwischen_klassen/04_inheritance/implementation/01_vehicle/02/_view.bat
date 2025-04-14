@echo off

set "file01=vehicle/FuelType.java"
set "file02=vehicle/Vehicle.java"
set "file03=vehicle/bike/BikeType.java"
set "file04=vehicle/bike/Motorcycle.java"
set "file05=vehicle/car/TransmissionType.java"
set "file06=vehicle/car/Car.java"
set "file07=vehicle/bus/Bus.java"
set "file08=vehicle/truck/Truck.java"
set "file09=main/Application.java"

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