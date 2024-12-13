package bridge.controller;

import bridge.generator.BridgeRandomNumberGenerator;
import bridge.handler.RetryHandler;
import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.model.Success;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeController(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        startBridgeGame();
    }

    private void startBridgeGame(){
        outputView.printStartMessage();
        int bridgeSize = RetryHandler.retryReturn(inputView::readBridgeSize);
        List<String> bridge = makeBridge(bridgeSize);
        crossBridge(bridge);
    }

    private List<String> makeBridge(int bridgeSize){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }

    private void crossBridge(List<String> bridge){
        BridgeGame bridgeGame = new BridgeGame();
        while (true){
            RetryHandler.retryVoid(() -> bridgeGame.move(inputView.readMoving(), bridge));
            printMovedResult(bridgeGame);
            if (!bridgeGame.getIsSuccess()){
                if (RetryHandler.retryReturn(inputView::readGameCommand)){
                    bridgeGame.retry();
                    continue;
                }
            }
            if (bridgeGame.getMovePosition() == bridge.size()){
                printFinalResult(bridgeGame);
                break;
            }
        }
    }

    private void printMovedResult(BridgeGame bridgeGame){
        outputView.printMap(bridgeGame.getUpperBridge(), bridgeGame.getLowerBridge());
    }

    private void printFinalResult(BridgeGame bridgeGame){
        String isSucceed = Success.FAIL.getIsSucceed();
        if (bridgeGame.getIsSuccess()){
            isSucceed = Success.SUCCESS.getIsSucceed();
        }
        outputView.printResult(bridgeGame.getUpperBridge(), bridgeGame.getLowerBridge(), isSucceed, bridgeGame.getTryCount());
    }


}
