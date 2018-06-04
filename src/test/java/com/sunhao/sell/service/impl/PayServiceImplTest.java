package com.sunhao.sell.service.impl;

import com.sunhao.sell.dto.OrderDTO;
import com.sunhao.sell.repository.OrderDetailRepository;
import com.sunhao.sell.repository.OrderMasterRepository;
import com.sunhao.sell.service.OrderService;
import com.sunhao.sell.service.PayService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PayServiceImplTest {

    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = orderService.findOne("1528125836179499033");
        payService.create(orderDTO);
    }
}