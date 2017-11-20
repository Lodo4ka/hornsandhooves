package com.testbackfortheinterview.interview.restcontroller;


import com.testbackfortheinterview.interview.entity.Furniture;
import com.testbackfortheinterview.interview.service.FurnitureSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order/furniture")
public class FurnitureRest {


    @Autowired
    private FurnitureSevice furnitureSevice;

    @RequestMapping(path = "/order/furniture/{name}")
    public ResponseEntity create(@PathVariable String name){
        Furniture result = furnitureSevice.create(name);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
