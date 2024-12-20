package com.yazi.minicart;

import com.yazi.minicart.dto.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiniCartApplication {

    public static void main(String[] args) {
        Product product = Product.builder().id((long)6).name("phone").description("ok").build();
        System.out.println(product);
        SpringApplication.run(MiniCartApplication.class, args);
    }

}
