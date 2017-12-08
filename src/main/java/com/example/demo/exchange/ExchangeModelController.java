package com.example.demo.exchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Component
@RequestMapping("/exchange")
public class ExchangeModelController {

    @Autowired
    ExchangeModelRepository exchangeModelRepository;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    Page<ExchangeModel> get(Pageable pageable){
        return exchangeModelRepository.findAll(pageable);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @ResponseBody
    ExchangeModel getId(@PathVariable("id")Long id){
        return exchangeModelRepository.findOne(id);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ResponseBody
    String delete(@PathVariable("id")Long id)throws Exception{
        exchangeModelRepository.delete(id);
        return "DELETED";
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    ExchangeModel post(@RequestBody ExchangeModel exchangeModel){
        return exchangeModelRepository.save(exchangeModel);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    @ResponseBody
    ExchangeModel delete (@PathVariable("id") Long id, @RequestBody ExchangeModel exchangeModel)throws Exception{
        return exchangeModelRepository.save(exchangeModel);
    }
}
