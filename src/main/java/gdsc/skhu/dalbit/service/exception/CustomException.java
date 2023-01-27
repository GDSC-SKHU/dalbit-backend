package gdsc.skhu.dalbit.service.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {
    public CustomException(String message, HttpStatus notAcceptable) {
    }
}
