package com.example.demo.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Component
@RequestMapping("/products")
public class ProductsModelController {

    @Autowired
    ProductsModelRepository productsModelRepository;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    Page<ProductsModel> get (Pageable pageable, @RequestParam(value = "g", required = false, defaultValue = "0") Long g){
        return productsModelRepository.findAll(pageable, g);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @ResponseBody
    ProductsModel productsModel (@PathVariable("id") Long id){
        return productsModelRepository.findOne(id);
    }



    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    ProductsModel post (@RequestBody ProductsModel productsModel) throws Exception{
        return productsModelRepository.save(productsModel);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ResponseBody
    String delete(@PathVariable("id") Long id){
        productsModelRepository.delete(id);
        return "DELETADO";
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    @ResponseBody
    ProductsModel put (@PathVariable("id") Long id, @RequestBody ProductsModel productsModel) throws Exception{
        return productsModelRepository.save(productsModel);
    }
}
