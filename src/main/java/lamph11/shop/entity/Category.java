package lamph11.shop.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "category")
public class Category extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer status;
    @ManyToOne
    @JoinColumn(
            name = "parent_id",
            referencedColumnName = "id"
    )
    private Category parent;

}
