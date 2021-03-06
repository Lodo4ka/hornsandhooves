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
public class FurnitureService {

    @Autowired
    private FurnitureRepository furnitureRepository;

    public Furniture create(Furniture furniture){

        if(furniture == null){
            return null;
        }

        String name = furniture.getName();

        if(name.equalsIgnoreCase("кровать") || name.equalsIgnoreCase("диван") || name.equalsIgnoreCase("кресло")){
            furniture.setPrice(30D);
             Department department = new Department("Unitex" , TypeDepartment.SOFT);
            furniture.setDepartment(department);
            Furniture savaFurniture = furnitureRepository.save(furniture);
            return savaFurniture;
        }

        if(name.equalsIgnoreCase("шкаф") || name.equalsIgnoreCase("тумба") || name.equalsIgnoreCase("полка")){
            furniture.setPrice(40D);
            furniture.setDepartment(new Department("8March" , TypeDepartment.SYSTEM));
            Furniture savaFurniture = furnitureRepository.save(furniture);
            return savaFurniture;
        }

        if(name.equalsIgnoreCase("стол") || name.equalsIgnoreCase("стул") || name.equalsIgnoreCase("кресло-качалка")){
            furniture.setPrice(50D);
            furniture.setDepartment(new Department("IKEA" , TypeDepartment.OFFICE));
            Furniture savaFurniture = furnitureRepository.save(furniture);
            return savaFurniture;
        }
        else {
            throw new NullPointerException("nothing saved");
        }
    }

    public List<Furniture> getAll(){
        List<Furniture> all = furnitureRepository.getAllBy();
        return all;
    }
}
