package shared;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LiquidType {
    WATER("Water"), SODA("Soda"), JUICE("Juice"), BEER("Beer");
    private final String name;
}