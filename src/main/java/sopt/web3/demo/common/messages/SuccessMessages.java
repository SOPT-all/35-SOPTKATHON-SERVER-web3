package sopt.web3.demo.common.messages;

public enum SuccessMessages {
    GET_LEVEL("성공"),
    GET_TODOLISTS("히스토리를 성공적으로 받아왔습니다."),
    GET_ALL_PERCENTAGE("성공률 관련 데이터를 불러왔습니다.");

    String message;

    SuccessMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
