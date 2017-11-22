package com.testbackfortheinterview.interview.service;


import com.testbackfortheinterview.interview.entity.Department;
import com.testbackfortheinterview.interview.entity.Furniture;
import com.testbackfortheinterview.interview.entity.enums.TypeDepartment;
import com.testbackfortheinterview.interview.entity.enums.TypeofFurniture;
import com.testbackfortheinterview.interview.repository.FurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureSevice {

    @Autowired
    private FurnitureRepository furnitureRepository;

    public Furniture create(String name){


        Furniture foundFurniture = furnitureRepository.findByName(name);

        if(foundFurniture == null){
            return null;
        }

        if(name.equalsIgnoreCase("кровать") || name.equalsIgnoreCase("диван") || name.equalsIgnoreCase("кресло")){
            foundFurniture.setTypeofFurniture(TypeofFurniture.SOFTFURNITURE);
            foundFurniture.setDepartment(new Department(TypeDepartment.SOFT));
        }

        if(name.equalsIgnoreCase("шкаф") || name.equalsIgnoreCase("тумба") || name.equalsIgnoreCase("полка")){
            foundFurniture.setTypeofFurniture(TypeofFurniture.SYSTEMFURNITURE);
            foundFurniture.setDepartment(new Department(TypeDepartment.SYSTEM));
        }

        if(name.equalsIgnoreCase("стол") || name.equalsIgnoreCase("стул") || name.equalsIgnoreCase("кресло-качалка")){
            foundFurniture.setTypeofFurniture(TypeofFurniture.OFFICEFURNITURE);
            foundFurniture.setDepartment(new Department(TypeDepartment.OFFICE));
        }

        return foundFurniture;
    }

    public List<Furniture> getAll(){
        List<Furniture> all = furnitureRepository.getAllBy();
        return all;
    }
}
