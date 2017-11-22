package com.testbackfortheinterview.interview.repository;

import com.testbackfortheinterview.interview.entity.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FurnitureRepository extends JpaRepository<Furniture, Long> {

    Furniture findByName(String name);

    List<Furniture> getAllBy();
}
