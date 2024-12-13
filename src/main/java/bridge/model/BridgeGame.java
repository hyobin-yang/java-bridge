package bridge.model;

import bridge.exception.ErrorMessages;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {

    private List<String> upperBridge;
    private List<String> lowerBridge;

    private int movePosition = 0;
    private boolean isSuccess = false;
    private int tryCount = 1;

    public BridgeGame(){
        this.upperBridge = new ArrayList<>();
        this.lowerBridge = new ArrayList<>();
    }

    public void move(String bridgeRowInput, List<String> bridge) {
        bridgeRowInput = validateBrideRow(bridgeRowInput);
        if (bridgeRowInput.equals(BridgeRow.UP.getBridgeRow())){
            moveToUpperBridge(bridge);
        }
        if (bridgeRowInput.equals(BridgeRow.DOWN.getBridgeRow())){
            moveToLowerBridge(bridge);
        }
    }

    private void moveToUpperBridge(List<String> bridge){
        if (bridge.get(movePosition).equals(BridgeRow.UP.getBridgeRow())){
            isSuccess = true;
            upperBridge.add(MoveExpression.GO.getExpression());
            lowerBridge.add(MoveExpression.NONE.getExpression());
        }
        if (bridge.get(movePosition).equals(BridgeRow.DOWN.getBridgeRow())){
            isSuccess = false;
            upperBridge.add(MoveExpression.STOP.getExpression());
            lowerBridge.add(MoveExpression.NONE.getExpression());
        }
        forwardToNextBridge();
    }

    private void moveToLowerBridge(List<String> bridge){
        if (bridge.get(movePosition).equals(BridgeRow.DOWN.getBridgeRow())){
            lowerBridge.add(MoveExpression.GO.getExpression());
            upperBridge.add(MoveExpression.NONE.getExpression());
            isSuccess = true;
        }
        if (bridge.get(movePosition).equals(BridgeRow.UP.getBridgeRow())){
            lowerBridge.add(MoveExpression.STOP.getExpression());
            upperBridge.add(MoveExpression.NONE.getExpression());
            isSuccess = false;
        }
        forwardToNextBridge();
    }

    private void forwardToNextBridge(){
        movePosition ++;
    }

    private String validateBrideRow(String bridgeRow){
        if (bridgeRow.trim().equals(BridgeRow.UP.getBridgeRow())){
            return BridgeRow.UP.getBridgeRow();
        }
        if (bridgeRow.trim().equals(BridgeRow.DOWN.getBridgeRow())){
            return BridgeRow.DOWN.getBridgeRow();
        }
        throw new IllegalArgumentException(ErrorMessages.INVALID_ROW_INPUT.getMessage());
    }

    public List<String> getUpperBridge(){
        return upperBridge;
    }

    public List<String> getLowerBridge(){
        return lowerBridge;
    }

    public int getMovePosition(){
        return movePosition;
    }

    public void retry() {
        initializeBridge();
        tryCount ++;
    }

    private void initializeBridge(){
        movePosition = 0;
        upperBridge.clear();
        lowerBridge.clear();
    }

    public boolean getIsSuccess(){
        return isSuccess;
    }

    public int getTryCount(){
        return tryCount;
    }
}
