package bridge.model;

public enum MoveExpression {
    GO("O"), STOP("X"), NONE(" ");

    private final String moveExpression;

    MoveExpression(String moveExpression){
        this.moveExpression = moveExpression;
    }

    public String getExpression(){
        return moveExpression;
    }
}
