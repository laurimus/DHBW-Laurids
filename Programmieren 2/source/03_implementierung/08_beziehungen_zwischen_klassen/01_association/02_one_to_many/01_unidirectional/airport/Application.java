import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String... args) {
        Gate gateA1 = new Gate("A1");
        Gate gateA2 = new Gate("A2");
        Gate gateA3 = new Gate("A3");

        Gate[] gates = {gateA1, gateA2, gateA3};

        Terminal terminalA = new Terminal("Terminal A", gates);
        log.info(String.valueOf(terminalA));

        log.info("--- gates in {} ---", terminalA.getTerminalName());
        for (Gate gate : terminalA.getGates()) {
            log.info(String.valueOf(gate));
        }
    }
}