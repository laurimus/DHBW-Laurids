import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
// n:m bidirectional association
public class Project {
    private final Set<Flashlight> flashlights = new HashSet<>();
    @Setter
    private String name;

    public Project(String name) {
        this.name = name;
    }

    public void addFlashlight(Flashlight flashlight) {
        this.flashlights.add(flashlight);
    }
}