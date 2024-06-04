package com.udea.parcialarqsoftback.controller;

import com.udea.parcialarqsoftback.model.DTO.StoreDTO;
import com.udea.parcialarqsoftback.model.Store;
import com.udea.parcialarqsoftback.services.StoreServices;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoreController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private StoreServices storeServices;

    @PostMapping(value = "", headers = "API-Version=1")
    public void addStore(@Valid @RequestBody StoreDTO storeDTO) {
        Store store = modelMapper.map(storeDTO, Store.class);
        storeServices.addStore(store);
    }

    @GetMapping(value = "", headers = "API-Version=1")
    public List<StoreDTO> getAllStores() {
        List<Store> stores = storeServices.getAllStores();
        return stores.stream().map(store -> modelMapper.map(store, StoreDTO.class)).toList();
    }
}
