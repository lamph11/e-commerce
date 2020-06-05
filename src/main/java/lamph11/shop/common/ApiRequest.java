package lamph11.shop.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ApiRequest<T> {

    @NotNull
    @Valid
    private T body;
    private Pageable page;
//    {
//        pageSize,
//        pageNumber
//    }
}
