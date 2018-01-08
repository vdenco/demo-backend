package com.example.demo.products;

import com.example.demo.security.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface ProductsModelRepository extends BaseRepository<ProductsModel> {

   @Query("select p from ProductsModel p where (p.group.id = :g or :g = 0 )")
    Page<ProductsModel> findAll(Pageable pageable, @Param("g") Long g);

   // Page<ProductsModel> findAllByGroup(Pageable pageable, Long id);
}
