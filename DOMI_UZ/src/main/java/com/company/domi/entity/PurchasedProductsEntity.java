package com.company.domi.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "myProducts")
@Data
public class PurchasedProductsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "image")
    private Attachment image;

    @Column(name="count")
    private Integer count;

    @Column(name="overall")
    private Integer overall;

    @Column(name = "phone")
    private String phone;

    @Column(name = "location")
    private String location;

}
