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

    public void addStore(Store store) {
        storeRepository.save(store);
    }

    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    public Store getStoreById(Long id) {
        return storeRepository.findById(id).orElse(null);
    }
}





