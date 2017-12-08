package com.example.demo.cxReceives;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Component
@RequestMapping("/cxreceives")
public class CxReceivesModelController {

    @Autowired
    CxReceivesModelRepository cxReceivesModelRepository;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    Page<CxReceivesModel> get(Pageable pageable){
        return cxReceivesModelRepository.findAll(pageable);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @ResponseBody
    CxReceivesModel getId(@PathVariable("id") Long id){
        return cxReceivesModelRepository.findOne(id);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    CxReceivesModel post(@RequestBody CxReceivesModel cxReceivesModel){
        return cxReceivesModelRepository.save(cxReceivesModel);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ResponseBody
    String delete(@PathVariable("id") Long id) throws Exception{
        cxReceivesModelRepository.delete(id);
        return "DELETED";
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    @ResponseBody
    CxReceivesModel put(@PathVariable("id") Long id, @RequestBody CxReceivesModel cxReceivesModel) throws Exception{
        return cxReceivesModelRepository.save(cxReceivesModel);
    }
}
