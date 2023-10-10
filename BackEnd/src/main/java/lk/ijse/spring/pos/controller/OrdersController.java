package lk.ijse.spring.pos.controller;

import lk.ijse.spring.pos.service.OrdersService;
import lk.ijse.spring.pos.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrdersController {

    @Autowired
    private OrdersService service;

    @GetMapping
    public ResponseUtil getAllOrders() {
        return new ResponseUtil("Ok", "Successful", service.getAllOrders());
    }
}
