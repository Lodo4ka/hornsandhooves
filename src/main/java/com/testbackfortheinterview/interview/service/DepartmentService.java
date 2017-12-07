package com.testbackfortheinterview.interview.service;

import com.testbackfortheinterview.interview.entity.Department;
import com.testbackfortheinterview.interview.entity.Order;
import com.testbackfortheinterview.interview.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


}
