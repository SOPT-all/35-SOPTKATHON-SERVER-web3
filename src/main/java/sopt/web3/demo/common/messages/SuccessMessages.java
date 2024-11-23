package sopt.web3.demo.common.messages;

public enum SuccessMessages {
    GET_LEVEL("레벨 불러오기 성공");

    String message;

    SuccessMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
