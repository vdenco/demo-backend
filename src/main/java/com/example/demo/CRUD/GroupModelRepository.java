package com.example.demo.CRUD;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin

public interface GroupModelRepository extends CrudRepository<GroupModel, Long> {

    @Override
    List<GroupModel> findAll();



}
