package com.udea.parcialarqsoftback.services;

import com.udea.parcialarqsoftback.model.Store;
import com.udea.parcialarqsoftback.model.jpa.IStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServices {
    @Autowired
    private IStoreRepository storeRepository;

    public Store addStore(Store store) {
        storeRepository.save(store);
        return store;
        
    }

    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    public Store getStoreById(Long id) {
        return storeRepository.findById(id).orElse(null);
    }
}





