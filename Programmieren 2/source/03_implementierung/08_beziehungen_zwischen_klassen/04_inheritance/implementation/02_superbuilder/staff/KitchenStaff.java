package staff;

import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString(callSuper = true)
public class KitchenStaff extends Staff {
    private String workStation;
    private String responsibilities;
}