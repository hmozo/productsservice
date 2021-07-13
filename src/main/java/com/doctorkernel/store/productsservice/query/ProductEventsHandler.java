package com.doctorkernel.store.productsservice.query;

import com.doctorkernel.store.productsservice.core.data.ProductsRepository;
import org.springframework.stereotype.Component;

@Component
public class ProductEventsHandler {
    private final ProductsRepository productsRepository;

    public ProductEventsHandler(ProductsRepository productsRepository) {
        this.productsRepository= productsRepository;
    }


}
