package com.example.demo.CRUD;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@CrossOrigin
@Component
@RequestMapping("/products")
public class ProductModelController {

    @Autowired
    private ProductModelRepository productModelRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    Page<ProductModel> findAll(Pageable pageable, @RequestParam(value = "q", required = false, defaultValue = "") String q) {
        return productModelRepository.findAll(pageable, q);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = POST)
    @ResponseBody
    ProductModel create(@RequestBody ProductModel productModel) throws Exception {

        if (productModel.getPrice() == null || productModel.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new Exception("Preco invalido");
        }
        return productModelRepository.save(productModel);

    }
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = GET, path = "/{id}")
    @ResponseBody
    ProductModel findOne(@PathVariable("id") Long id) {
        return productModelRepository.findOne(id);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = PATCH, path = "/{id}")
    @ResponseBody
    ProductModel create(@RequestBody ProductModel productModel, @PathVariable("id") Long id) throws Exception {

        if (productModel.getPrice() == null || productModel.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new Exception("Preco invalido");
        }

        if (!productModelRepository.exists(id)) {
            throw new NotFoundException("Not ounf");
        }

        productModel.setId(id);

        return productModelRepository.save(productModel);

    }
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = DELETE, path = "/{id}")
    String create(@PathVariable("id") Long id) throws Exception {

        productModelRepository.delete(id);

        return "ok";

    }
}
