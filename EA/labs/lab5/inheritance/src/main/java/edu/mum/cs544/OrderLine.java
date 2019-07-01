package edu.mum.cs544;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class OrderLine {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer quantity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    public OrderLine(Integer quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }
}
