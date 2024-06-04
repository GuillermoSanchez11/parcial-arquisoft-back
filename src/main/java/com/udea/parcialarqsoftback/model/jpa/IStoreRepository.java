package com.udea.parcialarqsoftback.model.jpa;

import com.udea.parcialarqsoftback.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStoreRepository extends JpaRepository<Store, Long> {
}