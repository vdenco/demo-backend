package com.example.demo.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Component
@RequestMapping("/group")
public class GroupModelController {

    @Autowired
    GroupModelRepository groupModelRepository;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    Page<GroupModel> get (Pageable pageable){
        return groupModelRepository.findAll(pageable);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    GroupModel post (@RequestBody GroupModel groupModel) throws Exception{
        return groupModelRepository.save(groupModel);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ResponseBody
    String delete (@PathVariable("id") Long id){
        groupModelRepository.delete(id);
        return "DELETED";
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    @ResponseBody
    GroupModel put (@PathVariable("id") Long id, @RequestBody GroupModel groupModel) throws Exception{
        return groupModelRepository.save(groupModel);
    }

}
