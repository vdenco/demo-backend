package com.example.demo.printers;

import javafx.print.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Component
@RequestMapping("/printers")
public class PrinterModelController {

    @Autowired
    PrintersModelsRepository printersModelsRepository;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    Page<PrintersModel> get (Pageable pageable){
        return printersModelsRepository.findAll(pageable);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    PrintersModel post (@RequestBody PrintersModel printersModel) throws Exception {
        return printersModelsRepository.save(printersModel);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ResponseBody
    String del(@PathVariable("id") Long id) throws Exception{
        printersModelsRepository.delete(id);
        return "DELETED";
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    @ResponseBody
    PrintersModel put (@PathVariable("id")Long id, @RequestBody PrintersModel printersModel) throws Exception{
        return printersModelsRepository.save(printersModel);
    }
}
