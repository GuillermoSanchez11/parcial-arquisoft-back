package com.udea.parcialarqsoftback.controller;


import com.udea.parcialarqsoftback.model.DTO.ProductDTO;
import com.udea.parcialarqsoftback.model.Product;
import com.udea.parcialarqsoftback.services.ProductServices;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stores/{storeId}/products")
public class ProductController {
    @Autowired
    private ProductServices productServices;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(value = "", headers = "API-Version=1")
    public ResponseEntity<ProductDTO> addProduct(@Valid @RequestBody ProductDTO productDTO, @PathVariable Long storeId) {
        Product product = modelMapper.map(productDTO, Product.class);
        ProductDTO addedProduct = modelMapper.map(productServices.addProduct(product, storeId, productDTO.getAmount()),
                ProductDTO.class);

        if (addedProduct == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<ProductDTO>(addedProduct, HttpStatus.CREATED);
    }

    @GetMapping(value = "", headers = "API-Version=1")
    public ResponseEntity<Iterable<Product>> getProductByStoreID(@PathVariable Long storeId) {
        return new ResponseEntity<>(productServices.getProductsByStoreID(storeId), HttpStatus.OK);
    }
}
