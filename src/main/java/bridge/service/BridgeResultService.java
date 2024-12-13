package bridge.service;

import bridge.dto.FinalResultDTO;
import bridge.model.BridgeGame;
import bridge.model.Success;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BridgeResultService {

    public FinalResultDTO registerFinalResult(BridgeGame bridgeGame){
        Map<String, List<String>> bridge = new HashMap<>();
        bridge.put("UP", bridgeGame.getUpperBridge());
        bridge.put("DOWN", bridgeGame.getLowerBridge());
        return new FinalResultDTO(bridge, checkSucceed(bridgeGame.getIsSuccess()), bridgeGame.getTryCount());
    }

    private String checkSucceed(boolean isSucceed){
        String result = Success.FAIL.getIsSucceed();
        if (isSucceed){
            result = Success.SUCCESS.getIsSucceed();
        }
        return result;
    }
}
