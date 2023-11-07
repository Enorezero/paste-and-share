package ru.enorezero.paste.and.share.pasteservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.enorezero.paste.and.share.pasteservice.model.ErrorMessage;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMessage> notFoundException(NotFoundException exception){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage(exception.getMessage()));
    }

    @ExceptionHandler(UnhashableLinkException.class)
    public ResponseEntity<ErrorMessage> unhashableLinkException(UnhashableLinkException exception){
        return ResponseEntity
                .status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
                .body(new ErrorMessage(exception.getMessage()));
    }

    @ExceptionHandler(StorageUnavaibleException.class)
    public ResponseEntity<ErrorMessage> storageUnavaibleException(StorageUnavaibleException exception){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorMessage(exception.getMessage()));
    }
}
