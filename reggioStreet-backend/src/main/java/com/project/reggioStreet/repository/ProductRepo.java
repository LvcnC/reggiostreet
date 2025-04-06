package com.project.reggioStreet.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.project.reggioStreet.model.Product;

// this interface will talk to the JPAREPOSITORY, which
// will HANDLE the connection/talk to the Database
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

    // being a child of JpaRepository, we are inheriting its METHOD

    // Let's create a COSTUM QUERY with hibernate!
    @Query(value="select * from product where name = :name", nativeQuery = true)
    List<Product> findByProductsName(String name);

    // maybe with numbers it wants the ?
    @Query(value="select * from product where qt = ?", nativeQuery = true)
    List<Product> findProductQuantity(int wantedQt);

    @Query(value="select * from product where qt > 0", nativeQuery = true)
    List<Product> availableQuantitybProducts();

    @Query(value="select * from product where product.status = ?", nativeQuery = true)
    List<Product> availableProducts(String status);

}
