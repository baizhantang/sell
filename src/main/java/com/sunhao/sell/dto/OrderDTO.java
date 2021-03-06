package com.sunhao.sell.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sunhao.sell.Entity.OrderDetail;
import com.sunhao.sell.enums.OrderStatusEnum;
import com.sunhao.sell.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author sunhao
 */
@Data
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class OrderDTO {

    /** 订单ID. */
    private String orderId;

    /** 买家名字. */
    private String buyerName;

    /** 买家手机号. */
    private String buyerPhone;

    /** 买家地址. */
    private String buyerAddress;

    /** 买家微信Openid. */
    private String buyerOpenid;

    /** 订单总金额. */
    private BigDecimal orderAmount;

    /** 订单状态，默认为0新下单. */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 支付状态，默认为0未支付. */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** 创建时间. */
    private Date createTime;

    /** 更新时间. */
    private Date updateTime;

    /** 订单所包含的项目. */
    private List<OrderDetail> orderDetailList;
}
