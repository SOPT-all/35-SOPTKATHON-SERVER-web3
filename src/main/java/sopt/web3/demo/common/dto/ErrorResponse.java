package sopt.web3.demo.common.dto;

public record ErrorResponse(
	boolean success,
	String message
) implements BaseResponse {

	public static ErrorResponse of(final String message) {
		return new ErrorResponse(false, message);
	}
}
