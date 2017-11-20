package com.testbackfortheinterview.interview.restcontroller;

import com.testbackfortheinterview.interview.entity.Order;
import com.testbackfortheinterview.interview.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DerartmentRest {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(path = "/orderAllDeraprtment/{id}", method = RequestMethod.GET)
    public ResponseEntity getAllOrderByDepartment(@PathVariable Long id){
        List<Order> result = departmentService.getAllOrderByDepartment(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
