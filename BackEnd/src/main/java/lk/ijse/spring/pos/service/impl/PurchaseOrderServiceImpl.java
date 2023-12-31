package lk.ijse.spring.pos.service.impl;

import lk.ijse.spring.pos.dto.OrderDetailsDTO;
import lk.ijse.spring.pos.dto.OrdersDTO;
import lk.ijse.spring.pos.entity.Item;
import lk.ijse.spring.pos.entity.Orders;
import lk.ijse.spring.pos.repo.ItemRepo;
import lk.ijse.spring.pos.repo.OrderDetailsRepo;
import lk.ijse.spring.pos.repo.OrdersRepo;
import lk.ijse.spring.pos.service.PurcheseOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
        if (ordersRepo.existsById(dto.getOid())) throw new RuntimeException("this order id is exist");

        ordersRepo.save(mapper.map(dto, Orders.class));

        List<OrderDetailsDTO> orderDetails = dto.getOrderDetails();
        for (OrderDetailsDTO detailsDTO : orderDetails) {
            String itemCode = detailsDTO.getItemCode();

            Item item = itemRepo.findById(itemCode).orElseThrow(() -> new RuntimeException("Item not found  " + itemCode));
            int qtyOnHand = item.getQtyOnHand();

            int updatedQty = qtyOnHand - detailsDTO.getQty();

            if (updatedQty >= 0) {
                item.setQtyOnHand(updatedQty);
                itemRepo.save(item);
            } else {
                throw new RuntimeException("Wrong " + itemCode);
            }

        }
    }
}
