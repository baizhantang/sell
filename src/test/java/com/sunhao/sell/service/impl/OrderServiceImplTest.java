package com.sunhao.sell.service.impl;

import com.sunhao.sell.Entity.OrderDetail;
import com.sunhao.sell.dto.OrderDTO;
import com.sunhao.sell.utils.KeyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {
    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("孙昊");
        orderDTO.setBuyerAddress("西山区");
        orderDTO.setBuyerPhone("18725083989");
        orderDTO.setBuyerOpenid("123123222");
        String orderId = KeyUtil.genUniqueKey();

        List<OrderDetail> orderDetailList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(orderId);
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setProductId("123123" + ((i%2==0)?"123":""));
            orderDetail.setProductQuantity(300 + i);
            orderDetailList.add(orderDetail);
        }

        orderDTO.setOrderId(orderId);
        orderDTO.setOrderDetailList(orderDetailList);

        orderService.create(orderDTO);
    }

    @Test
    public void findOne() {
    }

    @Test
    public void findList() {
    }

    @Test
    public void cancel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }
}