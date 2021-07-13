package com.doctorkernel.store.productsservice.query;

import com.doctorkernel.store.productsservice.core.data.ProductEntity;
import com.doctorkernel.store.productsservice.core.data.ProductsRepository;
import com.doctorkernel.store.productsservice.query.rest.ProductRestModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsQueryHandler {
    public final ProductsRepository productsRepository;

    public ProductsQueryHandler(ProductsRepository productsRepository) {
        this.productsRepository= productsRepository;
    }

    @QueryHandler
    List<ProductRestModel> findProducts(FindProductsQuery query){

        List<ProductRestModel> products= new ArrayList<>();
        List<ProductEntity> storedProducts= productsRepository.findAll();

        products= storedProducts.stream()
                .map(p->{
                    ProductRestModel prm= new ProductRestModel();
                    BeanUtils.copyProperties(p, prm);
                    return prm;
                }).collect(Collectors.toList());

        return products;
    }
}
