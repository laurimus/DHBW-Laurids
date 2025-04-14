package tcas;

import shared.Aircraft;

public interface ITrafficCollisionAvoidanceSystem {
    void detectAndResolveConflict(Aircraft aircraft01, Aircraft aircraft02);
}