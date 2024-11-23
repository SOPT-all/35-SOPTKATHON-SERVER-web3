package sopt.web3.demo.common.messages;

public enum SuccessMessages {
    GET_LEVEL("성공"),
    GET_TODOLISTS("히스토리를 성공적으로 받아왔습니다.");

    String message;

    SuccessMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
