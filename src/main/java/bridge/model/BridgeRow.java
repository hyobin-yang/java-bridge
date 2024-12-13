package bridge.model;

public enum BridgeRow {
    U(1), D(0);

    private final int bridgeRow;

    BridgeRow(int bridgeRow){
        this.bridgeRow = bridgeRow;
    }

    public static BridgeRow getBridgeRow(int number){
        if (number == U.bridgeRow){
            return U;
        }
        if (number == D.bridgeRow){
            return D;
        }
        throw new IllegalArgumentException("[SYSTEM]: 다리를 나타내는 숫자 입력이 잘못되었습니다.");
    }

}
