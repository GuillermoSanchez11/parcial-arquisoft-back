package com.udea.parcialarqsoftback.model.jpa;

import com.udea.parcialarqsoftback.model.ProductStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductStoreRepository extends JpaRepository<ProductStore, Long> {
}
