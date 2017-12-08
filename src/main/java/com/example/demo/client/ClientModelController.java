package com.example.demo.client;

import com.example.demo.products.ProductsModelController;
import com.example.demo.products.ProductsModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Component
@RequestMapping("/client")
public class ClientModelController {

    @Autowired
    ClientModelRepository clientModelRepository;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    Page<ClientModel> get (Pageable pageable){
        return clientModelRepository.findAll(pageable);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @ResponseBody
    ClientModel getId(@PathVariable("id") Long id){
        return clientModelRepository.findOne(id);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    ClientModel post(@RequestBody ClientModel clientModel){
        return clientModelRepository.save(clientModel);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ResponseBody
    String delete (@PathVariable("id") Long id) throws Exception{
        clientModelRepository.delete(id);

        return "DELETED";
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    @ResponseBody
    ClientModel put(@PathVariable("id") Long id, @RequestBody ClientModel clientModel) throws Exception{
        return clientModelRepository.save(clientModel);
    }
}
