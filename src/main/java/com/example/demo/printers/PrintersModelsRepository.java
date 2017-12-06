package com.example.demo.printers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface PrintersModelsRepository extends PagingAndSortingRepository<PrintersModel, Long> {

    @Query("select p from PrintersModel p")
    Page<PrintersModel> findAll(Pageable pageable);
}
