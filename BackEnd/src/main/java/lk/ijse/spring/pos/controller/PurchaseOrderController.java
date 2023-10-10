package lk.ijse.spring.pos.controller;

import lk.ijse.spring.pos.dto.OrdersDTO;
import lk.ijse.spring.pos.service.PurcheseOrderService;
import lk.ijse.spring.pos.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchaseorder")
@CrossOrigin
public class PurchaseOrderController {
    @Autowired
    private PurcheseOrderService service;

    @PostMapping
    public ResponseUtil purchaseOrder(@RequestBody OrdersDTO dto) {
        service.purcheseOrder(dto);
        return new ResponseUtil("Ok", "Successfull", dto);
    }
}
