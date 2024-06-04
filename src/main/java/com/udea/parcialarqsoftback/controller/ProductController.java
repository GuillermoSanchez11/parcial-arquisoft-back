package com.udea.parcialarqsoftback.controller;


import com.udea.parcialarqsoftback.model.DTO.ProductDTO;
import com.udea.parcialarqsoftback.model.Product;
import com.udea.parcialarqsoftback.services.ProductServices;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores/{storeId}/products")
public class ProductController {
    @Autowired
    private ProductServices productServices;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(value = "", headers = "API-Version=1")
    public void addProduct(@Valid @RequestBody ProductDTO productDTO, @RequestParam Long storeId) {
        Product product = modelMapper.map(productDTO, Product.class);
        productServices.addProduct(product, storeId, productDTO.getAmount());
    }

    @GetMapping(value = "", headers = "API-Version=1")
    public Iterable<Product> getProductByStoreID(@RequestParam Long storeId) {
        return productServices.getProductsByStoreID(storeId);
    }
}
