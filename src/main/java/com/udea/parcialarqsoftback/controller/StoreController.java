package com.udea.parcialarqsoftback.controller;

import com.udea.parcialarqsoftback.model.DTO.StoreDTO;
import com.udea.parcialarqsoftback.model.Store;
import com.udea.parcialarqsoftback.services.StoreServices;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<StoreDTO> addStore(@Valid @RequestBody StoreDTO storeDTO) {
        Store store = modelMapper.map(storeDTO, Store.class);
        StoreDTO addedStore = modelMapper.map(storeServices.addStore(store), StoreDTO.class);
        return new ResponseEntity<StoreDTO>(addedStore, HttpStatus.CREATED);
    }

    @GetMapping(value = "", headers = "API-Version=1")
    public ResponseEntity<List<StoreDTO>> getAllStores() {
        List<Store> stores = storeServices.getAllStores();
        List<StoreDTO> storeDTOS = stores.stream().map(store -> modelMapper.map(store, StoreDTO.class)).toList();
        return new ResponseEntity<List<StoreDTO>>(storeDTOS, HttpStatus.OK);
    }
}
