package com.yazi.minicart.service;


import com.yazi.minicart.dto.Product;
import com.yazi.minicart.entities.ProductEntity;
import com.yazi.minicart.repositories.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProductServiceMTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void testAddAndRetrieveProduct() {
        // Arrange
        Product product = Product.builder()
                .id(8L)
                .name("phone")
                .description("ok")
                .build();

        ProductEntity mockEntity = new ProductEntity();
        mockEntity.setId(8L);
        mockEntity.setName("phone");
        mockEntity.setDescription("ok");

        Mockito.when(productRepository.save(Mockito.any(ProductEntity.class))).thenReturn(mockEntity);
        Mockito.when(productRepository.findById(8L)).thenReturn(Optional.of(mockEntity));

        // Act
        ProductEntity output = productService.addProduct(product);
        ProductEntity retrievedProduct = productService.getProductById(8L);

        // Assert
        Assertions.assertNotNull(output, "The output should not be null");
        Assertions.assertEquals("phone", output.getName(), "The product name should match");
        Assertions.assertNotNull(retrievedProduct, "The retrieved product should not be null");
        Assertions.assertEquals("phone", retrievedProduct.getName(), "The retrieved product name should match");

        // Verify
        Mockito.verify(productRepository).save(Mockito.any(ProductEntity.class));
        Mockito.verify(productRepository).findById(8L);
    }
}
