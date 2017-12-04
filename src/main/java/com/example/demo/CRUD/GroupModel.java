
package com.example.demo.CRUD;


import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@CrossOrigin


@Entity
public class GroupModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    Long id;

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
