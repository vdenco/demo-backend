package com.example.demo.products;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface ProductsModelRepository extends PagingAndSortingRepository<ProductsModel, Long> {

    @Query("select p from ProductsModel p")
    Page<ProductsModel> findAll(Pageable pageable);
}
