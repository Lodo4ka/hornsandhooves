package com.testbackfortheinterview.interview.service;

import com.testbackfortheinterview.interview.entity.Order;
import com.testbackfortheinterview.interview.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order create(final Order order) {

        orderRepository.save(order);

        Order result = new Order();
        result.setId(order.getId());
        result.setName(order.getName());
        result.setComplete(order.isComplete());
        result.setTypeofFurniture(order.getTypeofFurniture());
        result.setCreateDateTime(order.getCreateDateTime());
        result.setWorkPeriod(order.getWorkPeriod());

        return result;
    }

    public List<Order> getAll() {
        List<Order> all = orderRepository.findAll();
        return all;
    }


    public List<Order> getNotCompleteOrder() {
        List<Order> all = orderRepository.findAll();

        List<Order> orderList = all.stream().filter(Order::isComplete)
                .collect(Collectors.toList());
        orderList.forEach(order->order.getMaster().toString().equals(order.getWorkPeriod().toString()));
        return orderList;

    }

    public int getPeriodEndDays() {
        int result = orderRepository.findAll()
                .stream().filter(Order::isComplete)
                .map(order->order.getWorkPeriod().getDayOfMonth() - order.getCreateDateTime().getDayOfMonth())
                .mapToInt(Integer::intValue)
                .sum();
        return result;
    }

    public int getPeriodEndHours() {
        int result = orderRepository.findAll()
                .stream().filter(Order::isComplete)
                .map(order->order.getWorkPeriod().getHour() - order.getCreateDateTime().getHour())
                .mapToInt(Integer::intValue)
                .sum();
        return result;
    }
}
