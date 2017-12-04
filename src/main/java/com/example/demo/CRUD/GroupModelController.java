package com.example.demo.CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@CrossOrigin
@Component
@RequestMapping("/groups")

public class GroupModelController {

    @Autowired
    private GroupModelRepository groupModelRepository;


    @CrossOrigin
    @RequestMapping(method = GET)
    @ResponseBody
    List<GroupModel> findAll() {
        return groupModelRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(method = POST)
    @ResponseBody
    GroupModel create(@RequestBody GroupModel groupModel) throws Exception {

        return groupModelRepository.save(groupModel);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = GET, path = "/{id}")
    @ResponseBody
    GroupModel findOne(@PathVariable("id") Long id) {
        return groupModelRepository.findOne(id);
    }
}
