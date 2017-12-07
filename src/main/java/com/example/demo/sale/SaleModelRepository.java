package com.example.demo.sale;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface SaleModelRepository extends PagingAndSortingRepository<SaleModel, Long> {
}
