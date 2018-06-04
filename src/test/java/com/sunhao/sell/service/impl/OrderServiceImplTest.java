package com.sunhao.sell.service.impl;

import com.sunhao.sell.Entity.OrderDetail;
import com.sunhao.sell.dto.OrderDTO;
import com.sunhao.sell.enums.OrderStatusEnum;
import com.sunhao.sell.enums.PayStatusEnum;
import com.sunhao.sell.utils.KeyUtil;
import org.aspectj.weaver.ast.Or;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {
    public static final String ORDER_ID = "1527670474162769169";
    public static final String BUYER_OPENID = "123123222";
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
        for (int i = 0; i < 2; i++) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(orderId);
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setProductId("123123" + ((i%2==0)?"123":""));
            orderDetail.setProductQuantity(3 + i);
            orderDetailList.add(orderDetail);
        }

        orderDTO.setOrderId(orderId);
        orderDTO.setOrderDetailList(orderDetailList);

        orderService.create(orderDTO);
    }

    @Test
    public void findOne() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);

        Assert.assertNotNull(orderDTO);

    }

    @Test
    public void findList() {

        Page<OrderDTO> orderDTOS = orderService.findList(BUYER_OPENID, new PageRequest(0, 2));
        Assert.assertNotEquals(0, orderDTOS.getContent().size());
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);

        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());

    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.finish(orderDTO);

        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(), result.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
    }
}