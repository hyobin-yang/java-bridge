package bridge.exception;

public enum ErrorMessages {
    INVALID_BRIDGE_SIZE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INVALID_ROW_INPUT("이동할 칸은 U 또는 D여야 합니다."),
    INVALID_RETRY_INPUT("재시도 여부는 R 또는 Q여야 합니다.");

    private final String message;

    ErrorMessages(String message){
        this.message = message;
    }

    public String getMessage(){
        return String.format("[ERROR] %s", message);
    }
}
