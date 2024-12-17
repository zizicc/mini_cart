package com.yazi.minicart.service;

import com.yazi.minicart.dto.Product;
import com.yazi.minicart.entities.ProductEntity;
import com.yazi.minicart.exceptions.ProductNotFoundException;
import com.yazi.minicart.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private  ProductRepository productRepository;


    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductEntity getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public ProductEntity addProduct(Product product) {
        ProductEntity newProduct = new ProductEntity();
        newProduct.setName(product.getName());
        newProduct.setDescription(product.getDescription());
        return productRepository.save(newProduct);
    }

    public ProductEntity updateProduct(Long id, Product updatedProduct) {
        return productRepository.findById(id)
                .map(existingProduct -> {
                    existingProduct.setName(updatedProduct.getName());
                    existingProduct.setDescription(updatedProduct.getDescription());
                    return productRepository.save(existingProduct); // save the updated product
                })
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found", "PRODUCT_NOT_FOUND"));
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product with ID " + id + " not found", "PRODUCT_NOT_FOUND");
        }
        productRepository.deleteById(id); // delete the product
    }

    public Page<ProductEntity> getPaginatedProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAll(pageable);
    }
}