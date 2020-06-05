package lamph11.shop.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private Integer status;
    private T body;
    private String message;

    public ApiResponse(T body){
        this.status=Status.SUCCESS.value();
        this.body=body;
    }

    public static ApiResponse fromException(Exception e){
        ApiResponse response=new ApiResponse();
        response.setStatus(Status.FAILURE.value());

        if(e instanceof MethodArgumentNotValidException){
            Map<String,String> errors = new HashMap<>();
            ((MethodArgumentNotValidException) e).getBindingResult()
                    .getFieldErrors()
                    .forEach(fieldError -> {
                        errors.put(fieldError.getField(),fieldError.getDefaultMessage());
                    });
            response.setBody(errors);
        }


        response.setMessage(e.getMessage());
        return response;
    }
}
