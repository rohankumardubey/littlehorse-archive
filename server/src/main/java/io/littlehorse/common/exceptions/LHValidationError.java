package io.littlehorse.common.exceptions;

public class LHValidationError extends LHException {

    public LHValidationError(Exception exn, String msg) {
        super(exn, msg);
    }

    public LHValidationError(String msg) {
        super(null, msg);
    }
}
