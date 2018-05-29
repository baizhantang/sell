package com.sunhao.sell.dto;

import lombok.Data;

/**
 * @author sunhao
 * @create 2018 - 05 -  30  上午12:46
 */
@Data
public class CartDTO {

    /** 商品ID. */
    private String productId;

    /** 数量. */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
