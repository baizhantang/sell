package com.sunhao.sell.service.impl;

import com.sunhao.sell.dto.OrderDTO;
import com.sunhao.sell.enums.ResultEnum;
import com.sunhao.sell.exception.SellException;
import com.sunhao.sell.service.BuyerService;
import com.sunhao.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sunhao
 * @create 2018-05-31  下午11:43
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid, orderId);
    }

    private OrderDTO checkOrderOwner(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);

        if (orderDTO != null) {
            //判断是否是自己的订单
            if (!orderDTO.getBuyerOpenid().equals(openid)) {
                log.error("【查询订单】订单的openID不一致， openID={}, orderDTO={}", openid, orderDTO);
                throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
            }
        } else {
            return null;
        }
        return orderDTO;
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if (orderDTO == null) {
            log.error("【取消订单】查不到该订单， orderId={}", orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        return orderService.cancel(orderDTO);
    }
}
