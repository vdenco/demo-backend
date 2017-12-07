package com.example.demo.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Component
@RequestMapping("/sale")
public class SaleModelController {

    @Autowired
    SaleModelRepository saleModelRepository;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    Page<SaleModel> get (Pageable pageable){
        return saleModelRepository.findAll(pageable);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @ResponseBody
    SaleModel getId(@PathVariable("id") Long id) {
        return saleModelRepository.findOne(id);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    SaleModel post (@RequestBody SaleModel saleModel) throws Exception{
        return saleModelRepository.save(saleModel);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ResponseBody
    String delete (@PathVariable("id") Long id){
        saleModelRepository.delete(id);

        return "DELETED";
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    @ResponseBody
    SaleModel put(@PathVariable("id") Long id, @RequestBody SaleModel saleModel) throws Exception{
        return saleModelRepository.save(saleModel);
    }
}
