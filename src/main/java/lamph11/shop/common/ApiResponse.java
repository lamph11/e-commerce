package lamph11.shop.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private Integer status;
    private T body;
    private String message;

    public ApiResponse(T body){
        this.body=body;
    }

    public static ApiResponse fromException(Exception e){
        ApiResponse response=new ApiResponse();
        response.setStatus(Status.FAILURE.value());
        response.setMessage(e.getMessage());
        return response;
    }
}
