package com.example.demo.cxReceives;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface CxReceivesModelRepository extends PagingAndSortingRepository<CxReceivesModel, Long> {
}
