package kr.co.memberservice.error.exception;

import kr.co.memberservice.error.model.ErrorCode;

public class UnauthorizedException extends BusinessLogicException{

    public UnauthorizedException() {
        super(ErrorCode.UNAUTHORIZED_USER);
    }
}