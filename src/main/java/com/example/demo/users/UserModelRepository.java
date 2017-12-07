package com.example.demo.users;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface UserModelRepository extends PagingAndSortingRepository<UserModel, Long> {
}
