package com.udea.parcialarqsoftback.services;

import com.udea.parcialarqsoftback.model.DTO.ProductDTO;
import com.udea.parcialarqsoftback.model.Product;
import com.udea.parcialarqsoftback.model.ProductStore;
import com.udea.parcialarqsoftback.model.Store;
import com.udea.parcialarqsoftback.model.jpa.IProductRepository;
import com.udea.parcialarqsoftback.model.jpa.IProductStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {
    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IProductStoreRepository productStoreRepository;

    @Autowired
    private StoreServices storeServices;

    public Product addProduct(Product product, Long storeId, Integer amount) {
        Product addedProduct = productRepository.save(product);
        ProductStore productStore = new ProductStore();
        productStore.setProduct(addedProduct);
        Store store = storeServices.getStoreById(storeId);
        if (store == null) {
            return null;
        }
        productStore.setStore(store);
        productStore.setAmount(amount);

        productStoreRepository.save(productStore);
        return addedProduct;
    }

    public Iterable<Product> getProductsByStoreID(Long id) {
        return productRepository.findByStoreId(id);
    }
}
