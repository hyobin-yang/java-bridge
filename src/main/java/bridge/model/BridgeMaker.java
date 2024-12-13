package bridge.model;

import bridge.generator.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i=0; i < size; i++){
            int number = bridgeNumberGenerator.generate();
            if (BridgeRow.getBridgeRow(number).equals(BridgeRow.UP)){
                bridge.add(BridgeRow.UP.getBridgeRow());
            }
            if (BridgeRow.getBridgeRow(number).equals(BridgeRow.DOWN)){
                bridge.add(BridgeRow.DOWN.getBridgeRow());
            }
        }
        return bridge;
    }
}
