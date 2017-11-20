package com.testbackfortheinterview.interview.restcontroller;

import com.testbackfortheinterview.interview.entity.Order;
import com.testbackfortheinterview.interview.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MasterRest {


    @Autowired
    private MasterService masterService;


    @RequestMapping(path = "/master/{id}/listOrders", method = RequestMethod.GET)
    public ResponseEntity getAllOrderByMaster(@PathVariable Long id){
        List<Order> result = masterService.getAllOrderByMaster(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(path = "/masters/{masterName}/alias/{aliasMasterName}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable String masterName, @PathVariable String aliasMasterName){
        boolean result = masterService.deleteAndRemapping(masterName, aliasMasterName);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
