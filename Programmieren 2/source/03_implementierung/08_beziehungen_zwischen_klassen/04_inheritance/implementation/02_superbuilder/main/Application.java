package main;

import base.Gender;
import customer.MemberShipLevel;
import customer.RegularCustomer;
import customer.VIPCustomer;
import lombok.extern.slf4j.Slf4j;
import staff.Cashier;
import staff.KitchenStaff;
import staff.Manager;
import staff.Position;

@Slf4j
public class Application {
    public static void main(String... args) {
        Manager manager = Manager.builder()
                .name("Alice")
                .age(40)
                .gender(Gender.FEMALE)
                .employeeId("M001")
                .position(Position.MANAGER)
                .salary(75000)
                .department("operations")
                .teamSize(15)
                .build();

        Cashier cashier = Cashier.builder()
                .name("Bob")
                .age(25)
                .gender(Gender.MALE)
                .employeeId("C102")
                .position(Position.CASHIER)
                .salary(25000)
                .shift("morning")
                .registerId(3)
                .build();

        KitchenStaff kitchenStaff = KitchenStaff.builder()
                .name("Eve")
                .age(28)
                .gender(Gender.FEMALE)
                .employeeId("K301")
                .position(Position.KITCHEN_STAFF)
                .salary(32000)
                .workStation("grill")
                .responsibilities("prepare and grill patties")
                .build();

        RegularCustomer regularCustomer = RegularCustomer.builder()
                .name("Charlie")
                .age(30)
                .gender(Gender.MALE)
                .customerId("R123")
                .contactInfo("charlie@example.com")
                .loyaltyPoints(150)
                .build();

        VIPCustomer vipCustomer = VIPCustomer.builder()
                .name("Diana")
                .age(35)
                .gender(Gender.FEMALE)
                .customerId("VIP001")
                .contactInfo("diana@example.com")
                .discountRate(0.15)
                .membershipLevel(MemberShipLevel.GOLD)
                .build();

        log.info("manager          : {}", manager);
        log.info("cashier          : {}", cashier);
        log.info("kitchen staff    : {}", kitchenStaff);
        log.info("regular customer : {}", regularCustomer);
        log.info("vip customer     : {}", vipCustomer);
    }
}