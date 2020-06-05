package lamph11.shop.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.domain.Pageable;

@Data
public class ApiRequest<T> {

    private T body;
    private Pageable page;
//    {
//        pageSize,
//        pageNumber
//    }
}
