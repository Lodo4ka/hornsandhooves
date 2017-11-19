package com.testbackfortheinterview.interview.restcontroller;

import com.testbackfortheinterview.interview.entity.Order;
import com.testbackfortheinterview.interview.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.RollbackException;
import java.util.List;

@RestController
@RequestMapping("/")
public class OrderRest {

    @Autowired
    private OrderService orderService;

    @RequestMapping(path = "/order", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody Order order){

        try{
            Order createorder = orderService.create(order);
            return new ResponseEntity<>(createorder, HttpStatus.OK);
        }
        catch (RollbackException e){
            return new ResponseEntity<>( null, HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(path = "/order/listOrder", method = RequestMethod.GET)
    public ResponseEntity<List<Order>> getAllOrder(){

        List<Order> result = orderService.getAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(path = "/order/notCompleteList", method = RequestMethod.GET)
    public ResponseEntity<List<Order>> getNotCompleteOrder(){
        List<Order> orderList = orderService.getNotCompleteOrder();
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @RequestMapping(path = "/order/days", method = RequestMethod.GET)
    public ResponseEntity getPeriodEndDays(){
        int periodEndDays = orderService.getPeriodEndDays();
        return new ResponseEntity<>(periodEndDays, HttpStatus.OK);
    }

    @RequestMapping(path = "/order/hours", method = RequestMethod.GET)
    public ResponseEntity getPeriodEndHours(){
        int periodEndHours = orderService.getPeriodEndHours();
        return new ResponseEntity<>(periodEndHours, HttpStatus.OK);
    }
}
