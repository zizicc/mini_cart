package com.yazi.minicart.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "products") // Optional: Specify the table name if it's different from the entity name
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate IDs
    private long id;

    @Column(nullable = false) // Name is required
    private String name;

    @Column(length = 500) // Optional: Limit description size
    private String description;

    public ProductEntity(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public ProductEntity() {
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "ProductEntity(id=" + this.getId() + ", name=" + this.getName() + ", description=" + this.getDescription() + ")";
    }
}