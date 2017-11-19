package com.testbackfortheinterview.interview.repository;

import com.testbackfortheinterview.interview.entity.Master;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterRepository extends JpaRepository<Master, Long>{

    Master findByFirtstName(String name);
}
