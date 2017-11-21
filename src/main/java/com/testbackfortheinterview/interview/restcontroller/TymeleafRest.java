package com.testbackfortheinterview.interview.restcontroller;


import com.testbackfortheinterview.interview.entity.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TymeleafRest {

    private static List<Order> orders = new ArrayList<>();

    static {
        orders.add(new Order("Blah"));
        orders.add(new Order("fsdgdf"));
    }

    // ​​​​​​​
    // Вводится (inject) из application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping(value = {"/templates/orderList.html"}, method = RequestMethod.GET)
    public String personList(Model model) {

        model.addAttribute("orders", orders);

        return "personList";
    }

    @RequestMapping(value = {"/templates/addOrder.html"}, method = RequestMethod.GET)
    public String showAddPersonPage(Model model) {

        Order order = new Order();
        model.addAttribute("personForm", order);

        return "addOrder";
    }

    @RequestMapping(value = { "/addOrder" }, method = RequestMethod.POST)
    public String savePerson(Model model,
                             @ModelAttribute("personForm") Order order) {

        long id = order.getId();
        String name = order.getName();

        if (id != 0 && name.length() > 0 //
                && name != null) {
            Order newOrder = new Order(id, name);
            orders.add(newOrder);

            return "redirect:/orderList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addOrder";
    }

}
