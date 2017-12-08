package com.example.demo.client;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface ClientModelRepository extends PagingAndSortingRepository<ClientModel, Long>{
}
