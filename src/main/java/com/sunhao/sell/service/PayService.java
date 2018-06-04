package com.sunhao.sell.service;

import com.lly835.bestpay.model.PayResponse;
import com.sunhao.sell.dto.OrderDTO;

/**
 * @author sunhao
 * @create 2018-06-03  下午6:01
 */
public interface PayService {

    PayResponse create(OrderDTO orderDTO);
}
