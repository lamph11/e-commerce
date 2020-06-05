package lamph11.shop.common;

import lombok.Data;

public enum  Status {

    SUCCESS(0),
    FAILURE(1);

    private final Integer status;

    public Integer value(){
        return this.status;
    }

    Status(Integer status){
        this.status=status;
    }
}
