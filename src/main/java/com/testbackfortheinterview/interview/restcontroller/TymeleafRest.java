//package com.testbackfortheinterview.interview.restcontroller;
//
//
//import com.testbackfortheinterview.interview.entity.Order;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//public class TymeleafRest {
//
//    private static List<Order> orders = new ArrayList<>();
//
//    static {
//        orders.add(new Order("Blah"));
//        orders.add(new Order("fsdgdf"));
//    }
//
//    // ​​​​​​​
//    // Вводится (inject) из application.properties.
//    @Value("${welcome.message}")
//    private String message;
//
//    @Value("${error.message}")
//    private String errorMessage;
//
//    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
//    public String index(Model model) {
//
//        model.addAttribute("message", message);
//
//        return "index";
//    }
//
//    @RequestMapping(value = {"/orderList"}, method = RequestMethod.GET)
//    public String orderList(Model model) {
//
//        model.addAttribute("orders", orders);
//
//        return "orderList";
//    }
//
//    @RequestMapping(value = {"/addOrder"}, method = RequestMethod.GET)
//    public String addOrder(Model model) {
//
//        Order order = new Order();
//        model.addAttribute("order", order);
//
//        return "addOrder";
//    }
//
//    @RequestMapping(value = { "/addOrder" }, method = RequestMethod.POST)
//    public String saveOrder(Model model,
//                             @ModelAttribute("order") Order order) {
//
//        long id = order.getId();
//        String name = order.getName();
//
//        if (id != 0 && name.length() > 0 //
//                && name != null) {
//            Order newOrder = new Order(id, name);
//            orders.add(newOrder);
//
//           return  "redirect:/orderList";
//        }
//
//        model.addAttribute("errorMessage", errorMessage);
//        return "addOrder";
//    }
//
//}
