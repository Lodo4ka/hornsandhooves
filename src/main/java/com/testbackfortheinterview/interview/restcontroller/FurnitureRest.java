package com.testbackfortheinterview.interview.restcontroller;


import com.testbackfortheinterview.interview.entity.Furniture;
import com.testbackfortheinterview.interview.service.FurnitureSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FurnitureRest {

    @Autowired
    private FurnitureSevice furnitureSevice;

    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping(value = {"/addOrder"}, method = RequestMethod.POST)
    public ModelAndView saveOrder(@ModelAttribute String name) {

        ModelAndView modelAndView = new ModelAndView("order");
        if (name.length() > 0
                && name != null) {
            Furniture newFurniture = furnitureSevice.create(name);
            String message = "Furniture was successfully added";
            modelAndView.addObject("message", message);
            return modelAndView;
        }
        modelAndView.addObject("errorMessage", errorMessage);
        return null;
    }

    @RequestMapping(value = {"/addOrder"}, method = RequestMethod.GET)
    public ModelAndView addOrder(){
        ModelAndView modelAndView = new ModelAndView("addOrder");
        modelAndView.addObject("order", new Furniture());
        return modelAndView;
    }

    @RequestMapping(value = {"orderList"}, method = RequestMethod.GET)
    public String orderList(Model model) {
        List<Furniture> orders = furnitureSevice.getAll();
        model.addAttribute("orders", orders);
        return "orderList";
    }


}
