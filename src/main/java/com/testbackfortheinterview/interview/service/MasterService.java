package com.testbackfortheinterview.interview.service;


import com.testbackfortheinterview.interview.entity.Master;
import com.testbackfortheinterview.interview.entity.Order;
import com.testbackfortheinterview.interview.repository.MasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterService {


    @Autowired
    private MasterRepository masterRepository;

    public List<Order> getAllOrderByMaster(Long id) {
        Master foundMaster = masterRepository.findOne(id);
        return foundMaster.getOrderList();
    }

    public boolean deleteAndRemapping(String name, String aliasName) {

        Master master = masterRepository.findByFirtstName(name);
         if(master != null){
             Master aliasMaster = masterRepository.findByFirtstName(aliasName);
             List<Order> masterOrderList = master.getOrderList();
             aliasMaster.setOrderList(masterOrderList);
             masterRepository.delete(master);
             return true;
         }
         else {
             return false;
         }

    }

}
