package com.example.demo.CRUD;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(exported = false)
public interface ProductModelRepository extends PagingAndSortingRepository<ProductModel, Long> {

    @Query("select p from ProductModel p where upper(p.id) like upper(concat('%', :q, '%'))")
    Page<ProductModel> findAll(Pageable pageable, @Param("q") String q);
}
