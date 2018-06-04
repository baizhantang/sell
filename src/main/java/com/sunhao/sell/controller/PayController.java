package com.sunhao.sell.controller;

import com.lly835.bestpay.model.PayResponse;
import com.sunhao.sell.dto.OrderDTO;
import com.sunhao.sell.enums.ResultEnum;
import com.sunhao.sell.exception.SellException;
import com.sunhao.sell.service.OrderService;
import com.sunhao.sell.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunhao
 * @create 2018-06-03  下午5:56
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl) {
        //查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        //发起支付
        PayResponse payResponse = payService.create(orderDTO);
        Map<String, Object> map = new HashMap<>();
        map.put("payResponse", payResponse);

        return new ModelAndView("pay/create", map);
    }
}
