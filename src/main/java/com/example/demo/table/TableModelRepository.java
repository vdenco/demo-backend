package com.example.demo.table;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface TableModelRepository extends PagingAndSortingRepository<TableModel, Long> {
}
