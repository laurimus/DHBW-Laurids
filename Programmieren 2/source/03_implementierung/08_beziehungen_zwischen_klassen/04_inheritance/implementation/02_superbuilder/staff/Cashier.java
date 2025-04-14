package staff;

import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString(callSuper = true)
public class Cashier extends Staff {
    private String shift;
    private int registerId;
}