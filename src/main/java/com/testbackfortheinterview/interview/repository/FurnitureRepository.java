package com.testbackfortheinterview.interview.repository;

import com.testbackfortheinterview.interview.entity.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FurnitureRepository extends JpaRepository<Furniture, Long> {

    Furniture findByName(String name);
}
