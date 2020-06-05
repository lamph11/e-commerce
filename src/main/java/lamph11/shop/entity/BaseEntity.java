package lamph11.shop.entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.Instant;

@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    protected Instant createdDate;
    protected String createdBy;
    protected Instant updatedDate;
    protected String updatedBy;
}
