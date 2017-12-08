package com.example.demo.productProduct;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface ProductProductRepository extends PagingAndSortingRepository<ProductProductModel, Long>{
}
