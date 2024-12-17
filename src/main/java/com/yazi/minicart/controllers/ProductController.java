package com.yazi.minicart.controllers;

import com.yazi.minicart.dto.Product;
import com.yazi.minicart.entities.ProductEntity;
import com.yazi.minicart.exceptions.ProductNotFoundException;
import com.yazi.minicart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marks this class as a RESTful controller
@RequestMapping("/products") // Base URL for all endpoints in this controller
public class ProductController {

    @Autowired
    private ProductService productService;

    // Get all products
    @GetMapping
    public List<ProductEntity> getAllProducts() {
        return productService.getAllProducts();
    }

    // Get a product by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> getProductById(@PathVariable Long id) {
        try {
            ProductEntity product = productService.getProductById(id);
            return ResponseEntity.ok(product);
        } catch (ProductNotFoundException e) {
            return ResponseEntity.notFound().build(); // 返回 404
        }
    }

    // Add a new product
    @PostMapping("")
    public ResponseEntity<ProductEntity> addProduct(@RequestBody Product product) {
        System.out.println(product.toString());
        ProductEntity createdProductEntity = productService.addProduct(product);
        return ResponseEntity.ok(createdProductEntity); // Return 200 with the created product
    }

    // Update an existing product
    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> updateProduct(
            @PathVariable Long id,
            @RequestBody Product updatedProduct) {
        try {
            ProductEntity product = productService.updateProduct(id, updatedProduct);
            return ResponseEntity.ok(product); // Return 200 with success
        } catch (ProductNotFoundException e) {
            return ResponseEntity.notFound().build(); // Return 404 with failure
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        try {
            productService.deleteProduct(id);
            return ResponseEntity.noContent().build(); // return 204 No Content
        } catch (ProductNotFoundException e) {
            return ResponseEntity.notFound().build(); // return 404 Not Found
        }
    }

    @GetMapping("/paginated")
    public ResponseEntity<Page<ProductEntity>> getPaginatedProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size) {
        Page<ProductEntity> products = productService.getPaginatedProducts(page, size);
        return ResponseEntity.ok(products);
    }

}