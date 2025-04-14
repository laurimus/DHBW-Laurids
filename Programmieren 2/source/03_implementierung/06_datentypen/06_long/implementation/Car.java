import lombok.Data;

@Data
public class Car {
    // long | twos complement integer
    //        default : 0
    //        size    : 64 bits
    //        range   : -9223372036854775808 to 9223372036854775807

    private long serialNumber;
}