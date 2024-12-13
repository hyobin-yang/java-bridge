package bridge.model;

public enum BridgeRow {
    UP("U", 1), DOWN("D", 0);

    private final String bridgeRow;
    private final int bridgeRowNumber;

    BridgeRow(String bridgeRow, int bridgeRowNumber){
        this.bridgeRow = bridgeRow;
        this.bridgeRowNumber = bridgeRowNumber;
    }

    public String getBridgeRow(){
        return bridgeRow;
    }

    public static String getBridgeRow(int number){
        if (number == UP.bridgeRowNumber){
            return UP.bridgeRow;
        }
        if (number == DOWN.bridgeRowNumber){
            return DOWN.bridgeRow;
        }
        throw new IllegalArgumentException("[SYSTEM]: 다리를 나타내는 숫자 입력이 잘못되었습니다.");
    }

}
