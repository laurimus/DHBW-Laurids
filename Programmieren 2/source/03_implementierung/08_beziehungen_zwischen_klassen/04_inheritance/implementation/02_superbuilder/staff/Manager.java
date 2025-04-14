package staff;

import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString(callSuper = true)
public class Manager extends Staff {
    private String department;
    private int teamSize;
}