package com.example.demo.afterSales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Component
@RequestMapping("/aftersales")
public class AfterSalesController {

    @Autowired
    AfterSalesRepository afterSalesRepository;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    Page<AfterSalesModel> get(Pageable pageable){
        return afterSalesRepository.findAll(pageable);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @ResponseBody
    AfterSalesModel getId(@PathVariable("id") Long id){
        return afterSalesRepository.findOne(id);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    AfterSalesModel post(@RequestBody AfterSalesModel afterSalesModel) throws Exception{
        return afterSalesRepository.save(afterSalesModel);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ResponseBody
    String delete(@PathVariable("id") Long id) throws Exception{
        afterSalesRepository.delete(id);
        return "DELETED";
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    @ResponseBody
    AfterSalesModel put(@PathVariable("id")Long id, @RequestBody AfterSalesModel afterSalesModel) throws Exception{
        return afterSalesRepository.save(afterSalesModel);
    }
}
