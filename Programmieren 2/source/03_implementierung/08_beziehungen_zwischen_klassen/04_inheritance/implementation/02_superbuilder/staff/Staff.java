package staff;

import base.Human;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString(callSuper = true)
public abstract class Staff extends Human {
    private String employeeId;
    private Position position;
    private double salary;
}