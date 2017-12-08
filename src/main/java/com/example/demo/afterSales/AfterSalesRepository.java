package com.example.demo.afterSales;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface AfterSalesRepository extends PagingAndSortingRepository<AfterSalesModel, Long> {
}
