package com.example.demo.exchange;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.Entity;

@CrossOrigin
public interface ExchangeModelRepository extends PagingAndSortingRepository<ExchangeModel, Long> {
}
