package lk.ijse.spring.pos.service.impl;

import lk.ijse.spring.pos.dto.OrdersDTO;
import lk.ijse.spring.pos.repo.ItemRepo;
import lk.ijse.spring.pos.repo.OrderDetailsRepo;
import lk.ijse.spring.pos.repo.OrdersRepo;
import lk.ijse.spring.pos.service.PurcheseOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PurchaseOrderServiceImpl implements PurcheseOrderService {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void purcheseOrder(OrdersDTO dto) {

    }
}
