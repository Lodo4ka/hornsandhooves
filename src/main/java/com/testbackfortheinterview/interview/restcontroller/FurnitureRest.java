package com.testbackfortheinterview.interview.restcontroller;


import com.testbackfortheinterview.interview.entity.Furniture;
import com.testbackfortheinterview.interview.service.FurnitureSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class FurnitureRest {

    @Autowired
    private FurnitureSevice furnitureSevice;

    @Value("${welcome.message}")
    private String message;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping(path = "/order/furniture/{name}", method = RequestMethod.POST)
    public ResponseEntity addOrder(@PathVariable String name){
        Furniture result = furnitureSevice.create(name);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = {"/orderList"}, method = RequestMethod.GET)
    public String orderList(Model model){

        List<Furniture> orders = furnitureSevice.getAll();
        model.addAttribute("orders", orders);
        return "orders";
    }


}
