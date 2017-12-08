package com.example.demo.productProduct;

import com.example.demo.products.ProductsModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Component
@RequestMapping("/productproduct")
public class ProductProductController {

    @Autowired
    ProductProductRepository productProductRepository;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    Page<ProductProductModel> get(Pageable pageable){
        return productProductRepository.findAll(pageable);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @ResponseBody
    ProductProductModel getId(@PathVariable("id")Long id){
        return productProductRepository.findOne(id);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ResponseBody
    String delete(@PathVariable("id") Long id) throws Exception{
        productProductRepository.delete(id);
        return "DELETED";
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    ProductProductModel post(@RequestBody ProductProductModel productProductModel){
        return productProductRepository.save(productProductModel);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    @ResponseBody
    ProductProductModel put(@PathVariable("id") Long id, @RequestBody ProductProductModel productProductModel) throws Exception{
        return productProductRepository.save(productProductModel);
    }
}
