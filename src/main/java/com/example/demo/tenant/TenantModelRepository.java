package com.example.demo.tenant;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface TenantModelRepository extends PagingAndSortingRepository<TenantModel, Long> {
}
