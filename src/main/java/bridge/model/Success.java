package bridge.model;

public enum Success {
    SUCCESS("성공"), FAIL("실패");

    private final String isSucceed;

    Success(String isSucceed){
        this.isSucceed = isSucceed;
    }

    public String getIsSucceed(){
        return isSucceed;
    }
}
