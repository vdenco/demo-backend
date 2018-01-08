package com.example.demo.cxExtra;

import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;

@CrossOrigin
@Component
@RequestMapping ("/cxextra")
public class CxExtraModelController {

    @Autowired
    CxExtraModelRepository cxExtraModelRepository;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    Page<CxExtraModel> get(Pageable pageable){
        return cxExtraModelRepository.findAll(pageable);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @ResponseBody
    CxExtraModel getId(@PathVariable("id") Long id){
        return cxExtraModelRepository.findOne(id);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    CxExtraModel post(@RequestBody CxExtraModel cxExtraModel){
        return cxExtraModelRepository.save(cxExtraModel);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ResponseBody
    String del(@PathVariable("id") Long id) throws Exception{
        cxExtraModelRepository.delete(id);
        return "DELETED";
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    @ResponseBody
    CxExtraModel put(@PathVariable("id") Long id, @RequestBody CxExtraModel cxExtraModel) throws Exception{
        return cxExtraModelRepository.save(cxExtraModel);
    }
}
