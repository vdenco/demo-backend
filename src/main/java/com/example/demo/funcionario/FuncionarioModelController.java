package com.example.demo.funcionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Component
@RequestMapping("/funcionario")
public class FuncionarioModelController {

    @Autowired
    FuncionarioModelRepository funcionarioModelRepository;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    Page<FuncionarioModel> funcionarioModel (Pageable pageable) {
        return funcionarioModelRepository.findAll(pageable);
    }


    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    FuncionarioModel funcionarioModels(@RequestBody FuncionarioModel funcionarioModel) throws Exception{
        return funcionarioModelRepository.save(funcionarioModel);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, path = "/id")
    @ResponseBody
    String del (@PathVariable("id") Long id) throws Exception{
        funcionarioModelRepository.delete(id);

        return "DELETADO";
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, path = "/id")
    @ResponseBody
    FuncionarioModel funcionarioModels (@PathVariable("id") Long id, @RequestBody FuncionarioModel funcionarioModel) throws Exception{
        return funcionarioModelRepository.save(funcionarioModel);
    }

}
