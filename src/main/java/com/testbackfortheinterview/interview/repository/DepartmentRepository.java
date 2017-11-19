package com.testbackfortheinterview.interview.repository;

import com.testbackfortheinterview.interview.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
