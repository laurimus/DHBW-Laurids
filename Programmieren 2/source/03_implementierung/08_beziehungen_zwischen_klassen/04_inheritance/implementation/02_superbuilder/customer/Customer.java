package customer;

import base.Human;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString(callSuper = true)
public class Customer extends Human {
    private String customerId;
    private String contactInfo;
}