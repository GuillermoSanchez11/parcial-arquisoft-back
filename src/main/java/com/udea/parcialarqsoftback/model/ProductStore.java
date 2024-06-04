package com.udea.parcialarqsoftback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "product-store")
public class ProductStore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "storeId")
    private Store store;

    @Column(name = "amount")
    private Integer amount;
}
