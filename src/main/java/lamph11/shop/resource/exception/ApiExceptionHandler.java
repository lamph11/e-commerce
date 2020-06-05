package lamph11.shop.resource.exception;

import lamph11.shop.common.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handlerInvalidRequestBody(MethodArgumentNotValidException e){
        return ResponseEntity.badRequest().body(
                ApiResponse.fromException(e)
        );
    }
}
