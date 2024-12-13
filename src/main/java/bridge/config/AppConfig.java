package bridge.config;

import bridge.controller.BridgeController;
import bridge.service.BridgeResultService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class AppConfig {

    private InputView inputView(){
        return new InputView();
    }

    private OutputView outputView(){
        return new OutputView();
    }

    private BridgeResultService bridgeResultService(){
        return new BridgeResultService();
    }

    public BridgeController controller() {
        return new BridgeController(inputView(), outputView(), bridgeResultService());
    }
}
