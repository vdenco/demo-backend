package com.example.demo.sale;

import com.example.demo.products.ProductsModel;
import com.example.demo.products.ProductsModelRepository;
import com.example.demo.security.BaseRepository;
import com.example.demo.table.TableModel;
import com.example.demo.table.TableModelRepository;
import com.example.demo.users.UserModel;
import com.example.demo.users.UserModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@CrossOrigin
@Component
@RequestMapping("/sale")
public class SaleModelController {

    @Autowired
    SaleModelRepository saleModelRepository;

    @Autowired
    ProductsModelRepository productsModelRepository;

    @Autowired
    TableModelRepository tableModelRepository;

    @Autowired
    UserModelRepository userModelRepository;


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

    @CrossOrigin
    @RequestMapping(method = RequestMethod.OPTIONS)
    @ResponseBody
    SaleModel option() throws Exception{

        SaleModel saleModel = new SaleModel();

       // saleModelRepository.save(saleModel);

        Pageable pageable = new Pageable() {
            @Override
            public int getPageNumber() {
                return 0;
            }

            @Override
            public int getPageSize() {
                return 0;
            }

            @Override
            public int getOffset() {
                return 0;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public Pageable next() {
                return null;
            }

            @Override
            public Pageable previousOrFirst() {
                return null;
            }

            @Override
            public Pageable first() {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }
        };

        Page<ProductsModel> page = productsModelRepository.findAll(pageable);

        TableModel tableModel = tableModelRepository.findOne((long) 1);

        UserModel userModel = userModelRepository.findOne((long)1);

        saleModel.setObs("OBS");
        saleModel.setTable(tableModel);
        saleModel.setUser(userModel);


        saleModel.products = new ArrayList<>();

        List<ProductsModel> productsModels = page.getContent();

        for (ProductsModel productsModel : productsModels) {

            SaleItemModel saleItemModel = new SaleItemModel();

            saleItemModel.setAmount(new BigDecimal(2));
            saleItemModel.setProduct(productsModel);
            //saleItemModel.setSaleModel(saleModel);

            saleModel.products.add(saleItemModel);
        }

        return saleModelRepository.save(saleModel);
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, path = "/teste")
    ProductsModel put(@RequestBody ProductsModel productsModel) throws Exception {
        return productsModelRepository.update(productsModel);
    }
}
