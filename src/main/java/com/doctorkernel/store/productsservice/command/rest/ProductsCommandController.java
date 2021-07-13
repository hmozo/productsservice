package com.doctorkernel.store.productsservice.command.rest;

import com.doctorkernel.store.productsservice.command.CreateProductCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductsCommandController {
    private final Environment environment;
    private final CommandGateway commandGateway;

    public ProductsCommandController(Environment environment, CommandGateway commandGateway) {
        this.environment= environment;
        this.commandGateway= commandGateway;
    }

    @PostMapping
    public String createProduct(@Valid @RequestBody CreateProductRestModel createProductRestModel) {
        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .productId(UUID.randomUUID().toString())
                .title(createProductRestModel.getTitle())
                .price(createProductRestModel.getPrice())
                .quantity(createProductRestModel.getQuantity())
                .build();

        String returnValue="";
        try {
            returnValue= commandGateway.sendAndWait(createProductCommand);
        }catch(Exception e) {
            returnValue= e.getLocalizedMessage();
        }

        return returnValue;
    }
}
