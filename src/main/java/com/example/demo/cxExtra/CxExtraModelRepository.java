package com.example.demo.cxExtra;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface CxExtraModelRepository extends PagingAndSortingRepository<CxExtraModel, Long> {
}
