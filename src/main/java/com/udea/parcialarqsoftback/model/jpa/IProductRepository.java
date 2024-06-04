package com.udea.parcialarqsoftback.model.jpa;


import com.udea.parcialarqsoftback.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p JOIN ProductStore s ON p.productId = s.product.productId WHERE s.store.storeId = ?1")
    public Iterable<Product> findByStoreId(Long id);
}
