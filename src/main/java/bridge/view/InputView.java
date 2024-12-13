package bridge.view;

import bridge.constant.BridgeConstant;
import bridge.exception.ErrorMessages;
import bridge.model.GameCommand;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String rawBridgeSize = Console.readLine();
        try{
            int bridgeSize = Integer.parseInt(rawBridgeSize.trim());
            if (bridgeSize >= BridgeConstant.MINIMUM_BRIDGE_SIZE && bridgeSize <= BridgeConstant.MAXIMUM_BRIDGE_SIZE){
                return bridgeSize;
            }
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(ErrorMessages.INVALID_BRIDGE_SIZE.getMessage());
        }
    }

    public String readMoving() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
        return Console.readLine();
    }

    public boolean readGameCommand() {
        String willRetry = Console.readLine();
        if (willRetry.equals(GameCommand.RETRY.getGameCommand())){
            return true;
        }
        if (willRetry.equals(GameCommand.QUIT.getGameCommand())){
            return false;
        }
        throw new IllegalArgumentException(ErrorMessages.INVALID_RETRY_INPUT.getMessage());
    }
}
