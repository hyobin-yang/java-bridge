package bridge.view;

import java.util.List;

public class OutputView {

    private static final String OPEN_SQUARE_BRACKETS = "[ ";
    private static final String CLOSE_SQUARE_BRACKETS = " ]";
    private static final String MOVE_DELIMITER = " | ";

    public void printStartMessage(){
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    public void printMap(List<String> upperBridge, List<String> lowerBridge) {
        String upperBridgeResult = String.join(MOVE_DELIMITER, upperBridge);
        String lowerBridgeResult = String.join(MOVE_DELIMITER, lowerBridge);
        System.out.println(OPEN_SQUARE_BRACKETS + upperBridgeResult + CLOSE_SQUARE_BRACKETS);
        System.out.println(OPEN_SQUARE_BRACKETS + lowerBridgeResult + CLOSE_SQUARE_BRACKETS);
    }

    public void printResult(List<String> upperBridge, List<String> lowerBridge, String isSuccess, int tryCount) {
        System.out.println("최종 게임 결과");
        printMap(upperBridge, lowerBridge);
        System.out.println();
        System.out.println("게임 성공 여부: " + isSuccess);
        System.out.println("총 시도한 횟수: " + tryCount);
    }
}