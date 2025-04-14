package base;

import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString
public abstract class Human {
    private String name;
    private int age;
    private Gender gender;
}