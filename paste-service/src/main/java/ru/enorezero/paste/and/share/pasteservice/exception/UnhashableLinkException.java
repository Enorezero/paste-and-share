package ru.enorezero.paste.and.share.pasteservice.exception;

public class UnhashableLinkException extends RuntimeException{
    public UnhashableLinkException(String message) {
        super(message);
    }
}
