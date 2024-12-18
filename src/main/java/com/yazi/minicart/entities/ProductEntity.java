package com.yazi.minicart.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate IDs
    private long id;

    @Column(name = "product_name", nullable = false) // Name is required
    private String name;

    @Column(name = "product_description",length = 500) // Optional: Limit description size
    private String description;


}