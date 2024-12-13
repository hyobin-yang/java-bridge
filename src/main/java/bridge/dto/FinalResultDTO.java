package bridge.dto;

import java.util.List;
import java.util.Map;

public class FinalResultDTO {

    private List<String> upperBridge;
    private List<String> lowerBridge;
    private String isSucceed;
    private int tryCount;

    public FinalResultDTO(Map<String, List<String>> bridge, String isSucceed, int tryCount){
        this.upperBridge = bridge.get("UP");
        this.lowerBridge = bridge.get("DOWN");
        this.isSucceed = isSucceed;
        this.tryCount = tryCount;
    }

    public List<String> getUpperBridge(){
        return upperBridge;
    }

    public List<String> getLowerBridge(){
        return lowerBridge;
    }

    public String getIsSucceed(){
        return isSucceed;
    }

    public int getTryCount(){
        return tryCount;
    }
}
