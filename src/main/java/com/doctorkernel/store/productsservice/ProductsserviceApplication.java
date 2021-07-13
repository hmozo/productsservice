package com.doctorkernel.store.productsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductsserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsserviceApplication.class, args);
	}

}
