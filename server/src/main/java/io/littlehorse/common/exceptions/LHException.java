package io.littlehorse.common.exceptions;

public class LHException extends Exception {

    protected Exception parent;
    protected String message;

    public LHException(Exception exn, String msg) {
        this.message = msg;
        this.parent = exn;
    }

    @Override
    public String getMessage() {
        return this.message + (parent == null ? "" : " " + parent.getMessage());
    }

    @Override
    public Throwable getCause() {
        return parent;
    }

    public void addPrefix(String prefix) {
        message = prefix + ": " + message;
    }
}
