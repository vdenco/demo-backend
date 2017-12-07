package com.example.demo.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Component
@RequestMapping("/table")
public class TableModelController {

    @Autowired
    TableModelRepository tableModelRepository;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    Page<TableModel> get (Pageable pageable){
        return tableModelRepository.findAll(pageable);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @ResponseBody
    TableModel getId(@PathVariable("id") Long id){
        return tableModelRepository.findOne(id);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    TableModel post (@RequestBody TableModel tableModel) throws Exception{
        return tableModelRepository.save(tableModel);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ResponseBody
    String delete (@PathVariable("id") Long id){
        tableModelRepository.delete(id);

        return "DELETED";
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    @ResponseBody
    TableModel put(@PathVariable("id") Long id, @RequestBody TableModel tableModel) throws Exception{
        return tableModelRepository.save(tableModel);
    }
}
