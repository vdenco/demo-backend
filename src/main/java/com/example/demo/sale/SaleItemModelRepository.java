package com.example.demo.sale;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface SaleItemModelRepository extends JpaRepository<SaleItemModel, Long> {
}
