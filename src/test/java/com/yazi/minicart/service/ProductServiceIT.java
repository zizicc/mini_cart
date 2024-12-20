package service;

import com.yazi.minicart.MiniCartApplication;
import com.yazi.minicart.dto.Product;
import com.yazi.minicart.entities.ProductEntity;
import com.yazi.minicart.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ContextConfiguration(classes = MiniCartApplication.class)
public class ProductServiceIT {

    @Autowired
    private ProductService productService;

    @Test
    public void test() {
        // 1. arrange
        Product product = Product.builder().id((long)7).name("phone").description("ok").build();

        // 2. act
        ProductEntity output = productService.addProduct(product);

        // 3. assert
        Assertions.assertNotNull(output);
        Assertions.assertNotNull(productService.getProductById((long)7));
        Assertions.assertEquals(productService.getProductById((long)7).getName(), "phone");
    }
}
