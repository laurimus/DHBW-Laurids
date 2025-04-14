package customer;

import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString(callSuper = true)
public class RegularCustomer extends Customer {
    private int loyaltyPoints;
}