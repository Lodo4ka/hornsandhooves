package com.testbackfortheinterview.interview.repository;

import com.testbackfortheinterview.interview.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
