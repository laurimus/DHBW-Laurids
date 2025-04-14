import lombok.Data;

@Data
public class Car {
    // short | twos complement integer
    //         default : 0
    //         size    : 16 bits
    //         range   : -32768 to 32767

    private short odometerValue;
}