package io.vizend.board.feature.exception;

public class ActionNotAllowedException extends RuntimeException{

    public ActionNotAllowedException(String message) {
        super(message);
    }
}
