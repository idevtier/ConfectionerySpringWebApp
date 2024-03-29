package com.belyaeva.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.File;


/**
 * status - delete product from catalog
 * */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(targetEntity = ProductType.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    @Column(name = "price")
    private int price;

    @Column(name = "image")
    private String image;

    @Column(name = "status")
    private boolean status;

    @Transient
    private String nameProductType;

    @Transient
    private MultipartFile icon;
}
