package com.example.demo.users;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

@CrossOrigin
@Component
@RequestMapping("/user")
public class UserModelController {

    @Autowired
    UserModelRepository userModelRepository;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    Page<UserModel> get (Pageable pageable){
        return userModelRepository.findAll(pageable);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @ResponseBody
    UserModel getId(@PathVariable("id") Long id){
        return userModelRepository.findOne(id);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    UserModel post(@RequestBody UserModel userModel)throws Exception{
        return userModelRepository.save(userModel);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ResponseBody
    String del(@PathVariable("id") Long id){
        userModelRepository.delete(id);

        return "DELETED";
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    @ResponseBody
    UserModel put(@PathVariable("id") Long id, @RequestBody UserModel userModel) throws Exception{
        return userModelRepository.save(userModel);
    }
}
