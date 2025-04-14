package machine;

import shared.Bottle;

import java.util.List;

public interface IMachine {
    void process(List<Bottle> bottles);
}