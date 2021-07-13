package com.doctorkernel.store.productsservice.core.data;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ProductsRepository extends JpaRepository<ProductEntity, String>{
	ProductEntity findByProductId(String productId);
}
