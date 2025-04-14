package customer;

import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString(callSuper = true)
public class VIPCustomer extends Customer {
    private double discountRate;
    private MemberShipLevel membershipLevel;
}